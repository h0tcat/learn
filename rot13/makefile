CC = g++
PGNAME = rot13Sample
OBJS = main.o Rot13.o

$(PGNAME):$(OBJS)
	$(CC) -o $@ $^

.cpp.o:
	$(CC) -c -o $@ $<


.PHONY:clean
clean:
	rm -f $(PGNAME) $(OBJS)
