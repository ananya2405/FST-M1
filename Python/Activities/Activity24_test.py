import pytest


@pytest.mark.parametrize("earned, spent, expected", [(30, 10, 20), (20, 2, 18)])
def test_wallet(wallet, earned, spent, expected):
    # amount in wallet after earning and spending
    wallet = (wallet + earned) - spent

    # assert the wallet amount is equal to what is expected
    assert wallet == expected
