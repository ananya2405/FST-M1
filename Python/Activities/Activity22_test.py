import pytest

# addition test


def test_calculator_sum():
    num1 = 10
    num2 = 20
    assert num1 + num2 == 30

# subtraction test
def test_calculator_subtract():
    num1 = 11
    num2 = 2
    assert num1 - num2 == 9

# multiplication test
@pytest.mark.activity
def test_product():
    num1 = 10
    num2 = 20
    assert num1 * num2 == 200

# Division test
@pytest.mark.activity
def test_division():
    num1 = 20
    num2 = 2
    assert num1 / num2 == 10
