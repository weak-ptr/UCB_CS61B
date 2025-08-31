#ifndef __DOG_PROBLEM_HPP__
#define __DOG_PROBLEM_HPP__

//  dependency
#include <vector>
#include <assert.h>
#include "Dog.hpp"

//  declaration
class DogProblem {
private:
    static constexpr int SCOPE = 2;
    static bool is_biggest_in_current_scope(const std::vector<Dog>& dogs, const int current_index);
    static bool is_current_index_valid(const std::vector<Dog>& dogs, const int current_index);

public:
    static std::vector<Dog>* larger_than_four_neighbors(const std::vector<Dog>& dogs);
};

inline bool DogProblem::is_current_index_valid(const std::vector<Dog>& dogs, const int current_index)
{
    return current_index > 0 && current_index < dogs.size();
}

inline bool DogProblem::is_biggest_in_current_scope(const std::vector<Dog>& dogs, const int current_index)
{
    //  default dogs[current_index] is the biggest dog
    bool state = true;

    for (int i = current_index - SCOPE; i < current_index + SCOPE + 1; i++)
    {
        //  if index is invalid, then pass it. and so on avoid ourself compare to ourself
        if (!is_current_index_valid(dogs, i) || i == current_index)
            continue;

        if (Dog::is_bigger(dogs[i], dogs[current_index]))
        {
            state = false;
            break;
        }
    }

    return state;
}

inline std::vector<Dog>* DogProblem::larger_than_four_neighbors(const std::vector<Dog>& dogs)
{
    std::vector<Dog>* point_to_result_dogs = nullptr;

    try {
        point_to_result_dogs = new std::vector<Dog>();
    } catch(const std::bad_alloc& ex) 
    {
        //  temporary
        assert(0);
    }

    for (int i = 0; i < dogs.size(); i++)
    {
        if (is_biggest_in_current_scope(dogs, i))
            point_to_result_dogs->push_back(dogs[i]);
    }

    return point_to_result_dogs;
}

#endif  /*  __DOG_PROBLEM_HPP__  */