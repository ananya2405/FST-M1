import pytest

# Using fixture from conftest.py file
def test_sum(list_input):
    sum = 0
    for i in list_input:
        sum = sum + i
    assert sum == 55



