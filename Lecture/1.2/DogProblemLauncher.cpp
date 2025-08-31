#include <memory>
#include "DogProblem.hpp"

int main(void)
{
    std::vector<Dog> dogs { 
        static_cast<Dog>(10), 
        static_cast<Dog>(15),
        static_cast<Dog>(20),
        static_cast<Dog>(15),
        static_cast<Dog>(10),
        static_cast<Dog>(5), 
        static_cast<Dog>(10), 
        static_cast<Dog>(15), 
        static_cast<Dog>(22),
        static_cast<Dog>(20)};

    std::unique_ptr<std::vector<Dog>> result (DogProblem::larger_than_four_neighbors(dogs));
    for (const Dog& dog : *result)
        std::cout << dog << " ";
    std::cout << std::endl;

    return 0;
}