import random

class GameBoard:
    
    def __init__(self, lengthx, lengthy, shoots, ladders):
        self.lengthx = lengthx
        self.lengthy = lengthy
        self.shoots = shoots
        self.ladders = ladders
        self.playerpos = 0


def initializeboard():

    f = open('C:\Users\Fisk\Desktop\chutes.txt', 'r')

    print f
    tempshoots =[]
    for line in f:
        a = line.splitlines()
        b = a[0].split(' ')
        c = [int(e) for e in b]
        tempshoots.append(c)

    #shoots = [map(int, x) for x in tempshoots]

    #shoots = [int(e) for e in tempshoots]
    print tempshoots

    f.close()
    f = open('C:\Users\Fisk\Desktop\ladders.txt', 'r')

    templadders = []

    for line in f:
        a = line.splitlines()
        b = a[0].split(' ')
        c = [int(e) for e in b]
        templadders.append(c)
    print templadders

    board = GameBoard(10,10, tempshoots, templadders)

    playgame(board)

def playgame(board):

    dice = [1,2,3,4,5,6]
    iterations = 0;
    f = open('C:\Users\Fisk\Desktop\stats.txt', 'a')
    
    while (board.playerpos < 100):
        roll = random.choice(dice)
        board.playerpos += roll
        print ("PLAYER HAS ROLLED: " + str(roll))

        for shoot in board.shoots:
            if board.playerpos == shoot[0]:
                board.playerpos = shoot[1]
                print "HIT A CHUTE"
                break
        for ladder in board.ladders:
             if board.playerpos == ladder[0]:
                board.playerpos = ladder[1]
                print "HIT A LADDER"
                break

        print board.playerpos
        iterations += 1
   
    f.write(str(iterations))
    f.write('\n')
    
def main():
    initializeboard()


if __name__ == "__main__":
    main()
