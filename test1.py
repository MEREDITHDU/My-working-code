import pytest

def test_one():
    print('test_one')
    assert 1


class TestNodeId:
    def test_one(self):
        print('TestNodeId::test_one')
        assert 1

    @pytest.mark.parametrize('x,y', [(1, 1), (3, 4)])
    def test_two(self, x, y):
        print(f'TestNodeId::test_two::{x} == {y}')
        assert x == y
