#include "Dog.hpp"

int main(void)
{
    Dog dogs[2] {static_cast<Dog>(7), static_cast<Dog>(51)};
    dogs[0].make_noise();
    dogs[1].make_noise();

    // Dog* new_dog = new Dog(43);
    // Dog* new_dogs = new Dog[4];
    Dog::max_dog(dogs[0], dogs[1]).make_noise();
    std::cout << Dog::binomen << std::endl;
}