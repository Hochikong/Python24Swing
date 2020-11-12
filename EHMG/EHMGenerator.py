# -*- coding: utf-8 -*-
# @Time    : 2020/11/1 14:10
# @Author  : Hochikong
# @FileName: EHMGenerator.py

# 此程序用于Netbeans自动生成的Swing代码，自动生成用于继承的protected方法
# 需要被识别的方法请用以下一对符号包住
# //<Auto-Generate> //</Auto-Generate>
# 对应的会在文件末端添加一个//<Auto-Generate-Result>和//</Auto-Generate-Result>包住的方法
# 至于其他的测试代码、自定义代码，请使用//<My-Custom>和//</My-Custom>包住

import argparse
import os


def scan_private_event_methods(filename: str, path: str) -> bool:
    class_name = filename.replace(".java", "")
    start_line = 0
    end_line = 0
    protected_method_sig = ["\n", "    //<Auto-Generate-Result>\n"]
    end_of_autogen_vars = 0

    with open(path, "r", encoding='utf-8') as java_code:
        all_lines = java_code.readlines()
        for index, line in enumerate(all_lines):
            if line.strip() == "//<Auto-Generate>":
                start_line = index
            if line.strip() == "//</Auto-Generate>":
                end_line = index
            if line.strip().startswith("// End of variables declaration"):
                end_of_autogen_vars = index

    head = all_lines[: start_line]
    auto_generate_range = all_lines[start_line: end_line + 1]
    middle = all_lines[end_line + 1: end_of_autogen_vars + 1]
    tail = all_lines[end_of_autogen_vars + 1:]

    method_count = 0
    for index1, line1 in enumerate(auto_generate_range):
        if line1.strip().startswith("private void") \
                and auto_generate_range[index1 + 1].strip().startswith("// TODO add your handling code here:"):
            method_count += 1

            line1 = line1[:line1.index("{")].strip()
            protected_method_sig.append(
                "    protected void imp%s{}\n" % line1.replace("private void", "").strip().strip("{"))

            method_name = line1.replace("private void", "").strip()
            bracket_index = method_name.index("(")
            auto_generate_range[index1 + 1] = "        imp%s(evt);\n" % method_name[:bracket_index]

    protected_method_sig.append("    //</Auto-Generate-Result>\n")

    print("Identified {} auto generate event methods".format(method_count))

    if method_count > 0:
        final_list = head + auto_generate_range + middle + protected_method_sig + tail

        # 更新包名
        # 更新类名
        # 规则1： public xxx()
        # 规则2： new xxx()
        # 规则3： xxx.class
        # 规则4:  public class xxx
        print("Class name: {}".format(class_name))
        print("Replacing {} to imp{}: ".format(class_name, class_name))
        for ind, row in enumerate(final_list):
            if "public class {}".format(class_name) in row:
                print("hit rule 4: 'public class {}' -> 'public class imp{}'".format(class_name, class_name))
                final_list[ind] = final_list[ind].replace(class_name, "imp{}".format(class_name))
            if "public {}".format(class_name) in row:
                print("hit rule 1: 'public {}()' -> 'public imp{}()'".format(class_name, class_name))
                final_list[ind] = final_list[ind].replace(class_name, "imp{}".format(class_name))
            if "new {}".format(class_name) in row:
                print("hit rule 2: 'new {}()' -> 'new imp{}()'".format(class_name, class_name))
                final_list[ind] = final_list[ind].replace(class_name, "imp{}".format(class_name))
            if "{}.class".format(class_name) in row:
                print("hit rule 3: '{}.class' -> 'imp{}.class'".format(class_name, class_name))
                final_list[ind] = final_list[ind].replace(class_name, "imp{}".format(class_name))
            if row.strip().startswith("package"):
                final_list[ind] = final_list[ind].rstrip().replace(";", ".") + "codegen;\n"

        if not os.path.exists("codegen"):
            os.mkdir("codegen")
        with open("codegen/imp{}".format(filename), 'w', encoding='utf-8') as f:
            f.writelines(final_list)
        return True

    else:
        print("Class name: {}".format(class_name))
        print("Due to no event handler functions found. No implementation code was generated.\n")
        return False


def exec_wrapper(file: str):
    if file.endswith(".java"):
        scan_private_event_methods(file, file)


def exec_wrapper_bulk(path: str):
    java_files = []
    finished = 0
    if os.path.exists(path):
        print("Try to find all java codes:")
        for filename in os.listdir(path):
            if filename.endswith(".java"):
                java_files.append(filename)

        java_files_count = len(java_files)

        if java_files_count > 0:
            print("All {} java codes found.".format(java_files_count))
            print("Try to analyse these java codes: \n")
            print("Java codes:")
            print("-----------------------------")

            for file in java_files:
                print(file)

            print("-----------------------------")
            print("\nStart: ############################\n")

            for file in java_files:
                if scan_private_event_methods(file, file):
                    finished += 1

            print("\n{} of {} java codes was generated new code.".format(finished, java_files_count))
            print("\nEnd: ############################\n")
        else:
            print("No java codes found. Script exit...\n")


def run():
    parser = argparse.ArgumentParser(
        description="""
        A simple code generator for NetBeans's to generate 'protected' event handler functions.
        """
    )
    parser.add_argument("-f", "--file", type=str, help="Target java file", metavar="xxxx.java")
    parser.add_argument("-p", "--path", type=str, help="Target path with one or more java files", metavar="xxxpath")
    args = parser.parse_args()

    if args.file:
        exec_wrapper(args.file)

    if args.path:
        exec_wrapper_bulk(args.path)


def run_test(file_path: str):
    if file_path.endswith(".java"):
        return scan_private_event_methods(file_path, file_path)


def run_test_bulk(dir_path: str):
    exec_wrapper_bulk(dir_path)


if __name__ == '__main__':
    run()
