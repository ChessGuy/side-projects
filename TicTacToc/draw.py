from turtle import Turtle

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

        # Draw lines to test code
        self.pensize(1)
        self.color('red')
        self.goto(-width / 2, text_bar_height)
        self.pendown()
        self.goto(width / 2, -height / 2)
        self.penup()

        self.goto(-width / 2, -height / 2)
        self.pendown()
        self.goto(width / 2, text_bar_height)
        self.penup()




