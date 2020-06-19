package webapplication.project.spacefood.model;

import java.util.List;

public class Alphabet {
    public static char[] alphabet = "tuvwxyz".toCharArray();

    public int check(char letter){

        if (letter == 'a'|| letter =='A'){
            return 1;
        }
        else if (letter == 'b'|| letter =='B')
            return 2;
        else if (letter == 'c'|| letter =='C')
            return 3;
        else if (letter == 'd'|| letter =='D')
            return 4;
        else if (letter == 'e'|| letter =='E')
            return 5;
        else if (letter == 'f'|| letter =='F')
            return 6;
        else if (letter == 'g'|| letter =='G')
            return 7;
        else if (letter == 'h'|| letter =='H')
            return 8;
        else if (letter == 'i'|| letter =='I')
            return 9;
        else if (letter == 'j'|| letter =='J')
            return 10;
        else if (letter == 'k'|| letter =='K')
            return 11;
        else if (letter == 'l'|| letter =='L')
            return 12;
        else if (letter == 'm'|| letter =='M')
            return 13;
        else if (letter == 'n'|| letter =='N')
            return 14;
        else if (letter == 'o'|| letter =='O')
            return 15;
        else if (letter == 'p'|| letter =='P')
            return 16;
        else if (letter == 'q'|| letter =='Q')
            return 17;
        else if (letter == 'r'|| letter =='R')
            return 18;
        else if (letter == 's'|| letter =='S')
            return 19;
        else if (letter == 't'|| letter =='T')
            return 20;
        else if (letter == 'u'|| letter =='U')
            return 21;
        else if (letter == 'v'|| letter =='V')
            return 22;
        else if (letter == 'w'|| letter =='W')
            return 23;
        else if (letter == 'x'|| letter =='X')
            return 24;
        else if (letter == 'y'|| letter =='Y')
            return 25;
        else if (letter == 'z'|| letter =='Z')
            return 26;

        else return 0;
    }




}
