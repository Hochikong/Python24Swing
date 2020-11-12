# -*- coding: utf-8 -*-
# @Time    : 2020/11/2 15:46
# @Author  : Hochikong
# @FileName: setup.py

from setuptools import setup, find_packages

setup(
    name='emg',
    version='0.1',

    description='Java swing code generator',

    author='Hochikong',
    author_email='ckhoidea@hotmail.com',

    classifiers=['License :: OSI Approved :: Mozilla Public License 2.0 (MPL 2.0)',
                 'Programming Language :: Python :: 3.8',
                 'Intended Audience :: Developers',
                 'Environment :: Console',
                 ],

    platforms=['Any'],

    entry_points={
        'console_scripts': [
            'emg=EHMG.EHMGenerator:run'
        ],
    },

    packages=find_packages(),
    include_package_data=True,

    zip_safe=False,
)
