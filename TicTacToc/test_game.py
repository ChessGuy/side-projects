import unittest
from game import Game


class TestGame(unittest.TestCase):

    # Board creation test
    def test_init(self):
        test_game = Game()
        self.assertTrue(([[0, 0, 0], [0, 0, 0], [0, 0, 0]] == test_game.board).all(),
                        'The Game class did not create the correct board')

    # Piece placement tests
    def test_play_piece_top_left_corner(self):
        test_game = Game()
        test_game.play_piece(1, (0, 0))
        self.assertTrue(([[1, 0, 0], [0, 0, 0], [0, 0, 0]] == test_game.board).all(),
                        'The piece was not played in the top left corner')

    def test_play_piece_top_right_corner(self):
        test_game = Game()
        test_game.play_piece(1, (0, 2))
        self.assertTrue(([[0, 0, 1], [0, 0, 0], [0, 0, 0]] == test_game.board).all(),
                        'The piece was not played in the top right corner')

    def test_play_piece_bottom_left_corner(self):
        test_game = Game()
        test_game.play_piece(1, (2, 0))
        self.assertTrue(([[0, 0, 0], [0, 0, 0], [1, 0, 0]] == test_game.board).all(),
                        'The piece was not played in the bottom left corner')

    def test_play_piece_bottom_right_corner(self):
        test_game = Game()
        test_game.play_piece(1, (2, 2))
        self.assertTrue(([[0, 0, 0], [0, 0, 0], [0, 0, 1]] == test_game.board).all(),
                        'The piece was not played in the bottom right corner')

    # Check wins tests
    def test_first_col_win(self):
        test_game = Game()
        test_game.board = [[1, 0, 0], [1, 0, 0], [1, 0, 0]]
        test_game.check_wins(1)
        self.assertTrue(test_game.game_over,
                        'First column win did not trigger a game over')
        self.assertTrue(test_game.winner == 1, 'Game did not return correct winner for first column win')

    def test_last_col_win(self):
        test_game = Game()
        test_game.board = [[0, 0, 1], [0, 0, 1], [0, 0, 1]]
        test_game.check_wins(1)
        self.assertTrue(test_game.game_over,
                        'Last column win did not trigger a game over')
        self.assertTrue(test_game.winner == 1, 'Game did not return correct winner for last column win')


    def test_first_row_win(self):
        test_game = Game()
        test_game.board = [[1, 1, 1], [0, 0, 0], [0, 0, 0]]
        test_game.check_wins(1)
        self.assertTrue(test_game.game_over,
                        'First row win did not trigger a game over')
        self.assertTrue(test_game.winner == 1, 'Game did not return correct winner for first row win')


    def test_last_row_win(self):
        test_game = Game()
        test_game.board = [[0, 0, 0], [0, 0, 0], [1, 1, 1]]
        test_game.check_wins(1)
        self.assertTrue(test_game.game_over,
                        'Last row win did not trigger a game over')
        self.assertTrue(test_game.winner == 1, 'Game did not return correct winner for last row win')


    def test_pos_diagonal_win(self):
        test_game = Game()
        test_game.board = [[0, 0, 1], [0, 1, 0], [1, 0, 0]]
        test_game.check_wins(1)
        self.assertTrue(test_game.game_over,
                        'Positive diagonal win did not trigger a game over')
        self.assertTrue(test_game.winner == 1, 'Game did not return correct winner for positive diagonal win')


    def test_neg_diagonal_win(self):
        test_game = Game()
        test_game.board = [[1, 0, 0], [0, 1, 0], [0, 0, 1]]
        test_game.check_wins(1)
        self.assertTrue(test_game.game_over,
                        'Negative diagonal win did not trigger a game over')
        self.assertTrue(test_game.winner == 1, 'Game did not return correct winner for negative diagonal win')


    def test_full_board_ends_game(self):
        test_game = Game()
        test_game.board = [[1, 1, 2], [2, 2, 1], [1, 1, 2]]
        test_game.check_wins(1)
        self.assertTrue(test_game.game_over,
                        'Full board did not end trigger a game over')
        self.assertTrue(test_game.winner == 0, 'Game did not return no winner for a full board game over')


if __name__ == '__main__':
    unittest.main()
