from game import Game
from turtle import Screen, Turtle
from draw import Draw


def print_click(x, y):
    # function to find and print the x, y coordinates of the mouse click location on the console
    print(x, y)


def receive_moves_from_click(x, y):
    if x > -246 and x < -92 and y > 51 and y < 194:
        game.play_piece(game.player_turn, (0, 0))
        print("it works")

    draw.draw_board(WIDTH, HEIGHT, TEXT_BOX, SPACING)
    draw.draw_pieces(HEIGHT, WIDTH, TEXT_BOX, PIECE_SPACING, game.board)
    draw.draw_text(game.player1, game.player2, game.player_turn, game.game_over, game.winner)
    print(game.board)
    game.check_wins(game.player_turn)
    print(game.game_over)
    game.change_player_turn()


# Constants

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
# game.player_turn = 1
# game.board = [[1, 1, 2], [2, 1, 1], [2, 2, 1]]
# game.check_wins(game.player_turn)
# print(game.winner)

draw = Draw()
draw.draw_board(WIDTH, HEIGHT, TEXT_BOX, SPACING)
draw.draw_pieces(HEIGHT, WIDTH, TEXT_BOX, PIECE_SPACING, game.board)
draw.draw_text(game.player1, game.player2, game.player_turn, game.game_over, game.winner)

# Main Game Loop

# while not game.game_over:
#     draw.draw_board(WIDTH, HEIGHT, TEXT_BOX, SPACING)
#     draw.draw_pieces(HEIGHT, WIDTH, TEXT_BOX, PIECE_SPACING, game.board)
#     draw.draw_text(game.player1, game.player2, game.player_turn, game.game_over, game.winner)
#
#     screen.onclick(receive_moves_from_click, 1)
#     screen.update()

screen.mainloop()
# screen.update()
screen.exitonclick()
