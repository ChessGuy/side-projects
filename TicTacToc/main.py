from game import Game
from turtle import Screen, Turtle
from draw import Draw

# Constants

def print_click (x, y):
    print(x, y)

WIDTH = 500
TEXT_BOX = 50
HEIGHT = WIDTH + TEXT_BOX
PIECE_SPACING = 50
SPACING = WIDTH / 3
CENTER_OF_BOARD = (HEIGHT - TEXT_BOX) / 2

TEXT_BAR_HEIGHT = CENTER_OF_BOARD - TEXT_BOX

# Screen set up

screen = Screen()
screen.setup(WIDTH, HEIGHT)
screen.bgcolor('black')
screen.title('Tic Tac Toe')
screen.tracer(0)

screen.onscreenclick(print_click, 1)
screen.listen()

# Draw the board

game = Game()
game.choose_first_player()
print(game.player_turn)
game.board = [[1, 1, 2], [2, 1, 1], [2, 2, 1]]

draw = Draw()
draw.draw_board(WIDTH, HEIGHT, TEXT_BOX, SPACING)
draw.draw_pieces(HEIGHT, WIDTH, TEXT_BOX, PIECE_SPACING, game.board)

screen.mainloop()
screen.update()
screen.exitonclick()





