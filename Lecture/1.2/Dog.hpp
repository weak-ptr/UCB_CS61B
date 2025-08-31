#ifndef __DOG_HPP__
#define __DOG_HPP__

#include <iostream>
#include <string_view>

class Dog {
public:
    inline static std::string_view binomen { "Calis familiaris" };

private:
    int weight_in_pound;

public:
    Dog()
     : weight_in_pound(0)
    {
        std::cout << "call default constructor!" << std::endl;
    }

    explicit Dog(int w)
     : weight_in_pound(w)
    {
        std::cout << "call explicit integer constructor!" << std::endl;
    }

    Dog(const Dog& d)
     : weight_in_pound(d.weight_in_pound)
    {
        std::cout << "call copy consturctor!" << std::endl;
    }

    Dog& operator=(const Dog& d)
    {
        if (this == &d)
            return *this;

        weight_in_pound = d.weight_in_pound;
        std::cout << "call assignment operator!" << std::endl;

        return *this;
    }

    void make_noise(void) const
    {
        std::string_view noise;

        if (weight_in_pound < 10)
			noise = "Yep!";
		else if (weight_in_pound < 30)
			noise = "Bark!";
		else 
			noise = "Wooooof!";

        std::cout << noise << std::endl;
    }

    static Dog max_dog(const Dog& d1, const Dog& d2)
    {
        Dog bigger;

        bigger = d1.weight_in_pound > d2.weight_in_pound ? d1 : d2;

        return bigger;
    }

    static bool is_bigger(const Dog& d1, const Dog& d2)
    {
        return d1.weight_in_pound > d2.weight_in_pound ? true : false;
    }

    friend std::ostream& operator<<(std::ostream& os, const Dog& dog)
    {
        os << dog.weight_in_pound;

        return os;
    }
};

#endif /*  __DOG_HPP__  */