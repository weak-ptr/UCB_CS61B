#include "placement_new.hpp"

int main(int args, char* argc[])
{
    //  allocation memory, but useless
    char buffer[sizeof(Book)];

    //  use 'new' initialize buffer
    Book* b = new (buffer) Book(404);
    std::cout << *b << std::endl;

    std::cout << "***  memory pool example  ***" << std::endl;
    //  create a memory pool
    MemoryPool pool;
    //  allocate memory from memory pool
    void* memory = pool.allocate(sizeof(Book));
    //  use placement new to initialize current memory
    Book* pb = new (memory) Book(100);
    //  check
    std::cout << *pb << std::endl;
    //  explicit invocation decontructor function
    pb->~Book(); 

    //  reset memory pool
    pool.reset();

    return 0;
}