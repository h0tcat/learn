#ifndef __ROT13_H__
#define __ROT13_H__

#include <iostream>
#include <string>
#include <cstring>

namespace nori{
	class Rot13{
		private:
			std::string word;
			int wordAsciiCode;
			size_t wordSize;
		public:
			Rot13();
			std::string Convert(char* plainText);

	};
};

#endif
