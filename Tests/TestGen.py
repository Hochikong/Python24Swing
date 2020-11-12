# -*- coding: utf-8 -*-
# @Time    : 2020/11/12 14:19
# @Author  : Hochikong
# @FileName: TestGen.py

from EHMG.EHMGenerator import run_test
from EHMG.EHMGenerator import run_test_bulk


def test_ident():
    assert run_test("LaunchView.java") is False
    assert run_test("MetaAdvanceSearch.java") is True


def test_ident_bulk():
    run_test_bulk(".")
