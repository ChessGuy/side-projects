from game import Game
from turtle import Screen, Turtle
from draw import Draw

# Constants

WIDTH = 500
TEXT_BOX = 50
HEIGHT = WIDTH + TEXT_BOX
SPACING = WIDTH / 3
CENTER_OF_BOARD = (HEIGHT - TEXT_BOX) / 2

TEXT_BAR_HEIGHT = CENTER_OF_BOARD - TEXT_BOX

# Screen set up

screen = Screen()
screen.setup(WIDTH, HEIGHT)
screen.bgcolor('black')
screen.title('Tic Tac Toe')
screen.tracer(0)

# Draw the board

draw = Draw()
draw.draw_board(WIDTH, HEIGHT, TEXT_BOX, SPACING)

game = Game()

screen.update()
screen.exitonclick()





