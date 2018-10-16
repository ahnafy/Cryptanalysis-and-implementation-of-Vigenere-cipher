# Cryptanalysis-and-Implementation-of-Vigenere-cipher.

Vigenere cipher is a polyalphabetic cipher. Its key is a word that is added (modulo 26) to each letter of the ciphertext. The keyword is repeated as many times as needed to match the length of the plaintext. Here is a more detailed description: http://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher.

Breaking Vigenere encryption is a harder task than breaking an affine cipher. Kasiski approach provides the basic idea: frequent letter combinations have a high probability of being encrypted by the same portion of the key words. Observing repeated patterns, one may guess the length of the keyword and even some of its letters.

If the keyword length is known, frequency analysis may be applied to characters encrypted by the same letter of the keyword: http://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher#Frequency_analysis.

Another potentially useful method is Key Elimination

