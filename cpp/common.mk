SRC := $(shell find . -type f -name "*.cpp")
BIN := $(SRC:.cpp=.out)

CC := g++
CPPFLAGS := -Wall -Werror -Wextra -g 
all: $(BIN)

clean: 
	rm -rf *.out *.stackdump core.*

%.out: %.cpp
	$(CC) $(CPPFLAGS) $< -o $@

.PHONY: all
