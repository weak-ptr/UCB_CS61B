#include <iostream>
#include <vector>
#include <cassert>

inline bool is_natural_number(const int number)
{
    return number > 0;
}

inline bool is_odd(const int number)
{
    return number % 2;
}

int next_collatz_number(const int number)
{
    int next_number = 0;

    if (is_odd(number))
        next_number = 3 * number + 1;
    else
        next_number = number / 2;

    return next_number;
}

std::vector<int> get_collatz_sequence(const int start_number)
{
    //  natural number check
    if ( !is_natural_number(start_number) )
        std::cerr << __FUNCTION__ << " was called with (" << start_number << ") which is invalid" << std::endl;

    int temp = start_number;
    std::vector<int> collatz_sequence;

    for (; temp != 1 ;)
    {
        //  store current number
        collatz_sequence.push_back(temp);

        //  get next valid number
        temp = next_collatz_number(temp);
    }

    //  add 1 to the end of collatz sequence
    collatz_sequence.push_back(temp);

    return collatz_sequence;
}

void print_collatz_sequence(const std::vector<int>& cs)
{
    for (auto& i : cs)
        std::cout << i << " ";
    std::cout << "\b" << std::endl;
}

void test_get_collatz_sequence_function(void)
{
    std::vector<int> t1 { 5, 16, 8, 4, 2, 1 };
    std::vector<int> r1 = get_collatz_sequence(t1[0]);

    assert(t1.size() == r1.size());
    for (int i = 0; i < t1.size(); i++)
        assert(t1[i] == r1[i]);

    std::vector<int> t2 { 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1 };
    std::vector<int> r2 = get_collatz_sequence(t2[0]);

    assert(t2.size() == r2.size());
    for (int i = 0; i < t2.size(); i++)
        assert(t2[i] == r2[i]);
}

int main() {

    test_get_collatz_sequence_function();

    return 0;
}
