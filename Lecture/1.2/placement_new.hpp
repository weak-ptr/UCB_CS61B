#ifndef __PLACEMENT_NEW_HPP__
#define __PLACEMENT_NEW_HPP__

#include <iostream>
#include <new>

//  example one
class Book {
private:
    int page;

private:
    friend std::ostream& operator<<(std::ostream& os, const Book& b);

public:
    Book(int p) : page(p)
    {
        std::cout << "invocation constructor, page = " << page << std::endl;
    }

    ~Book()
    {
        std::cout << "invocation destructor, page = " << page << std::endl;
    }
};

inline std::ostream& operator<<(std::ostream& os, const Book& b)
{
    os << "page: " << b.page;

    return os;
}

//  example two
class MemoryPool {
private:
    static constexpr size_t POOL_SIZE = 1024 * 1024;

    char* pool;
    char* current;

public:
    MemoryPool() : pool(static_cast<char*>(malloc(POOL_SIZE))), current(pool)
    {

    }

    ~MemoryPool()
    {
        free(pool);
    }

    void* allocate(const size_t sz) 
    {
        if (current + sz > pool + POOL_SIZE)
            throw std::bad_alloc();

        void* point = current;
        current += sz;

        return point;
    }

    void reset()
    {
        current = pool;
    }
};


#endif  /*  __PLACEMENT_NEW_HPP__  */