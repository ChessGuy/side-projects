from turtle import Turtle

ex_height = 120
ex_width = 100
diameter = 120

class Draw(Turtle):

    def __init__(self):
        super().__init__()
        self.hideturtle()
        self.top_line_thickness = 10
        self.board_thickness = 5

    def draw_board(self, width, height, text_box, spacing):
        self.color('white')
        self.pensize(self.top_line_thickness)
        center_of_board = (height - text_box) / 2
        text_bar_height = center_of_board - text_box

        # Draw Top Line
        self.penup()
        self.goto(-width / 2, text_bar_height)
        self.pendown()
        self.goto(width / 2, text_bar_height)
        self.penup()

        # Draw top Horizontal Line
        top_line_height = text_bar_height - spacing + (self.top_line_thickness + self.board_thickness)
        self.pensize(self.board_thickness)
        self.goto(-width / 2, top_line_height)
        self.pendown()
        self.goto(width / 2, top_line_height)
        self.penup()

        # Draw bottom Horizontal Line
        bottom_line_height = text_bar_height - 2 * spacing + (self.top_line_thickness + self.board_thickness)
        self.goto(-width / 2, bottom_line_height)
        self.pendown()
        self.goto(width / 2, bottom_line_height)
        self.penup()

        # Draw first Vertical Line
        vert_line_xcor = width / 2 - spacing + (self.top_line_thickness + self.board_thickness) / 2
        self.goto(-vert_line_xcor, -height)
        self.pendown()
        self.goto(-vert_line_xcor, text_bar_height)
        self.penup()

        # Draw second Vertical Line
        self.goto(vert_line_xcor, -height)
        self.pendown()
        self.goto(vert_line_xcor, text_bar_height)
        self.penup()

        # # Draw lines to test code
        # self.pensize(1)
        # self.color('red')
        # self.goto(-width / 2, text_bar_height)
        # self.pendown()
        # self.goto(width / 2, -height / 2)
        # self.penup()
        #
        # self.goto(-width / 2, -height / 2)
        # self.pendown()
        # self.goto(width / 2, text_bar_height)
        # self.penup()

    def draw_text(self, player1, player2, player_turn, game_over, winner):

        # Clear existing text
        self.color('black')
        self.pensize('60')
        self.goto(-246, 240)
        self.pendown()
        self.goto(232, 240)
        self.penup()
        self.pensize('5')
        # Draw Text at top of board

        self.goto(-225, 210)
        if player_turn == player1:
            self.color('blue')
        else:
            self.color('red')
        if game_over:
            self.color('gray')
            if winner == player1:
                self.write("Player 'X' wins!", font=("Arial", 45, "bold"))
            elif winner == player2:
                self.write("Player 'O' wins!", font=("Arial", 45, "bold"))
            else:
                self.write("Game Ends In Tie!", font=("Arial", 40, "bold"))
        elif player_turn == player1:
            self.write("Player 'X' Turn", font=("Arial", 45, "bold"))
        else:
            self.write("Player 'O' Turn", font=("Arial", 45, "bold"))
    def draw_circle(self, location):
        circle = Turtle()
        circle.color('red')
        circle.pensize(5)

        circle.hideturtle()
        circle.penup()
        circle.goto(location)
        circle.pendown()
        circle.circle(diameter / 2)

    def draw_ex(self, location):
        ex = Turtle()
        ex.color('blue')
        ex.pensize(5)
        ex_x_start = location[0]
        ex_y_start = location[1]
        ex.hideturtle()
        ex.penup()
        ex.goto(ex_x_start - ex_width / 2, ex_y_start)
        ex.pendown()
        ex.goto(ex_x_start + ex_width / 2, ex_y_start + ex_height)
        ex.penup()
        ex.goto(ex_x_start - ex_width / 2, ex_y_start + ex_height)
        ex.pendown()
        ex.goto(ex_x_start + ex_width / 2, ex_y_start)

    def create_piece_locations (self, height, width, text_box, spacing):
        locations = [[(0, 0), (0, 0), (0, 0)], [(0, 0), (0, 0), (0, 0)], [(0, 0), (0, 0), (0, 0)]]
        center_of_board = (height - text_box) / 2
        text_bar_height = center_of_board - text_box
        y_offset = 15
        x_offset = 15
        x_adjust = -25 # Since the spacing is not exact, this gets it closer

        for row in range(0, 3):
            for col in range(0, 3):
                locations[row][col] = (-width / 2 + (x_offset + diameter / 2) * (col + 1) + ((diameter + x_adjust) * col),
                                       text_bar_height - ((ex_height + y_offset) * (row + 1)) - (spacing / 2 * row))

        return locations

    def draw_pieces (self, height, width, text_box, spacing, board):
        locations = self.create_piece_locations(height, width, text_box, spacing)

        for row in range (0, 3):
            for col in range (0, 3):
                if board[row][col] == 1: # Ex Player
                    self.draw_ex(locations[row][col])
                elif board[row][col] == 2: # Circle Player
                    self.draw_circle(locations[row][col])














