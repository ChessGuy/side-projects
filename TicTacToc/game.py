import numpy as np


class Game:

    def __init__(self):
        self.board = np.zeros([3, 3])
        self.player_1 = 1
        self.player_2 = 2
        self.game_over = False

    def play_piece(self, player, location):
        self.board[location] = player

    def check_wins(self, player):
        board_state = self.board
        # Check for vertical wins
        for col in range(0, len(self.board)):
            if board_state[0][col] == player and board_state[1][col] == player and board_state[2][col] == player:
                self.game_over = True

        # Check for horizontal wins
        for row in range(0, len(self.board)):
            if board_state[row][0] == player and board_state[row][1] == player and board_state[row][2] == player:
                self.game_over = True

        # Check for positive diagonal win
        if board_state[2][0] == player and board_state[1][1] == player and board_state [0][2] == player:
            self.game_over = True

        # Check for negative diagonal win
        if board_state[0][0] == player and board_state[1][1] == player and board_state [2][2] == player:
            self.game_over = True
