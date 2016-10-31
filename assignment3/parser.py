
import re

def parse(inputString):

    # and *
    # or +
    # implies -
    # equi =
    # not !
    expressionList = []
    val = inputString.split('(',1)[1].split(')')[0]

    print (inputString.split('('))
    
    print (val)
    
   
def main():

    parse("(((A and B) or C) and D)")



if __name__ == "__main__":
    main()
