#include <cstdlib>
#include <iostream>
#include "Rot13.h"

int main(int argc,char** argv){

	if(argc!=2){
		std::cerr << "Usage: rot13Sample plainText"	 << std::endl;
		exit(0);
	}else{
		nori::Rot13 rot13Class;
		std::string result=rot13Class.Convert(argv[1]);
		
		std::cout << result << std::endl;
	}
	return 0;
}
