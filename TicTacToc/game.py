import random

import numpy as np

class Game:

    def __init__(self):
        self.board = np.zeros([3, 3])
        self.player_1 = 1
        self.player_2 = 2
        self.player_turn = 0
        self.game_over = False
        self.winner = 0
        self.full_board = False

    def choose_first_player (self):
        rand_num = random.randint(1, 2)
        if rand_num == 1:
            self.player_turn = 1
        else:
            self.player_turn = 2

    def play_piece(self, player, location):
        self.board[location] = player


    def check_wins(self, player):
        board_state = self.board
        # Check for vertical wins
        for col in range(0, len(self.board)):
            if board_state[0][col] == player and board_state[1][col] == player and board_state[2][col] == player:
                self.game_over = True
                self.winner = player

        # Check for horizontal wins
        for row in range(0, len(self.board)):
            if board_state[row][0] == player and board_state[row][1] == player and board_state[row][2] == player:
                self.game_over = True
                self.winner = player

        # Check for positive diagonal win
        if board_state[2][0] == player and board_state[1][1] == player and board_state [0][2] == player:
            self.game_over = True
            self.winner = player

        # Check for negative diagonal win
        if board_state[0][0] == player and board_state[1][1] == player and board_state [2][2] == player:
            self.game_over = True
            self.winner = player

        # Check for full board
        for row in range(0, len(self.board)):
            for col in range (0, len(self.board)):
                if board_state[row][col] != 0:
                    self.full_board = True
                else:
                    self.full_board = False

        if self.full_board:
            self.game_over = True

