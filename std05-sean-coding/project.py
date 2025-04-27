import pygame
import sys

# Initialize pygame
pygame.init()

# Screen dimensions
SCREEN_WIDTH, SCREEN_HEIGHT = 800, 600
screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
pygame.display.set_caption("Game Menu")

# Colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GRAY = (200, 200, 200)
BLUE = (0, 0, 255)
RED = (255, 0, 0)
GREEN = (0, 255, 0)

# Fonts
font = pygame.font.Font(None, 50)

class MenuController:
    """
    Controller for the main menu. Handles user input and navigation.
    """
    def __init__(self, menu_view):
        self.menu_view = menu_view
        self.selected_index = 0

    def handle_events(self):
        """
        Handles user input for navigating the menu.
        """
        mouse_pos = pygame.mouse.get_pos()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.MOUSEBUTTONDOWN:
                for i, rect in enumerate(self.menu_view.menu_rects):
                    if rect.collidepoint(mouse_pos):
                        return i
            if event.type == pygame.MOUSEMOTION:
                for i, rect in enumerate(self.menu_view.menu_rects):
                    if rect.collidepoint(mouse_pos):
                        self.selected_index = i
        return None

    def run(self):
        """
        Main loop for the menu.
        """
        while True:
            selected_game = self.handle_events()
            if selected_game is not None: return selected_game
            self.menu_view.draw(self.selected_index)

class MenuView:
    """
    View for the main menu. Handles rendering the menu on the screen.
    """
    def __init__(self, screen):
        self.screen = screen
        self.menu_options = ["Game 1: Catch the Ball", "Game 2: Avoid the Blocks", "Game 3: Simple Pong", "Game 4: Sean Game (Snake Game)"]
        self.menu_rects = []

    def draw(self, selected_index):
        """
        Draws the menu on the screen.
        """
        self.screen.fill(WHITE)
        title = font.render("Select a Game", True, BLACK)
        self.screen.blit(title, (SCREEN_WIDTH // 2 - title.get_width() // 2, 50))
        self.menu_rects = []

        for i, option in enumerate(self.menu_options):
            color = GRAY if i == selected_index else BLACK
            text = font.render(option, True, color)
            rect = text.get_rect(center=(SCREEN_WIDTH // 2, 150 + i * 100))
            self.menu_rects.append(rect)
            pygame.draw.rect(self.screen, GRAY if i == selected_index else WHITE, rect.inflate(20, 10))
            self.screen.blit(text, rect)

        pygame.display.flip()



class Game1:
    """
    Game 1: Catch the Ball. The player moves a paddle to catch a bouncing ball.
    """
    def __init__(self, screen):
        self.screen = screen
        self.clock = pygame.time.Clock()
        self.ball = pygame.Rect(400, 0, 30, 30)
        self.player = pygame.Rect(375, 550, 50, 10)
        self.ball_speed = [3, 3]
        self.score = 0

    def run(self):
        """
        Main loop for Game 1.
        """
        while True:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    return

            keys = pygame.key.get_pressed()
            if keys[pygame.K_LEFT] and self.player.left > 0:
                self.player.move_ip(-5, 0)
            if keys[pygame.K_RIGHT] and self.player.right < SCREEN_WIDTH:
                self.player.move_ip(5, 0)

            self.ball.move_ip(*self.ball_speed)
            if self.ball.left <= 0 or self.ball.right >= SCREEN_WIDTH:
                self.ball_speed[0] = -self.ball_speed[0]
            if self.ball.top <= 0:
                self.ball_speed[1] = -self.ball_speed[1]
            if self.ball.colliderect(self.player):
                self.ball_speed[1] = -self.ball_speed[1]
                self.score += 1
            if self.ball.bottom >= SCREEN_HEIGHT:
                return

            self.screen.fill(WHITE)
            pygame.draw.ellipse(self.screen, RED, self.ball)
            pygame.draw.rect(self.screen, BLUE, self.player)
            score_text = font.render(f"Score: {self.score}", True, BLACK)
            self.screen.blit(score_text, (10, 10))
            pygame.display.flip()
            self.clock.tick(60)


class Game2:
    """
    Game 2: Avoid the Blocks. The player avoids falling blocks.
    """
    def __init__(self, screen):
        self.screen = screen
        self.clock = pygame.time.Clock()
        self.player = pygame.Rect(375, 550, 50, 10)
        self.blocks = [pygame.Rect(x, 0, 50, 50) for x in range(0, SCREEN_WIDTH, 100)]
        self.block_speed = 5

    def run(self):
        """
        Main loop for Game 2.
        """
        while True:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    return

            keys = pygame.key.get_pressed()
            if keys[pygame.K_LEFT] and self.player.left > 0:
                self.player.move_ip(-5, 0)
            if keys[pygame.K_RIGHT] and self.player.right < SCREEN_WIDTH:
                self.player.move_ip(5, 0)

            for block in self.blocks:
                block.move_ip(0, self.block_speed)
                if block.colliderect(self.player):
                    return
                if block.top > SCREEN_HEIGHT:
                    block.y = -50

            self.screen.fill(WHITE)
            pygame.draw.rect(self.screen, BLUE, self.player)
            for block in self.blocks:
                pygame.draw.rect(self.screen, RED, block)
            pygame.display.flip()
            self.clock.tick(60)


class Game3:
    """
    Game 3: Simple Pong. A basic pong game with a player and an AI opponent.
    """
    def __init__(self, screen):
        self.screen = screen
        self.clock = pygame.time.Clock()
        self.ball = pygame.Rect(400, 300, 20, 20)
        self.player = pygame.Rect(375, 550, 100, 10)
        self.opponent = pygame.Rect(375, 50, 100, 10)
        self.ball_speed = [4, 4]
        self.player_speed = 5

    def run(self):
        """
        Main loop for Game 3.
        """
        while True:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    return

            keys = pygame.key.get_pressed()
            if keys[pygame.K_LEFT] and self.player.left > 0:
                self.player.move_ip(-self.player_speed, 0)
            if keys[pygame.K_RIGHT] and self.player.right < SCREEN_WIDTH:
                self.player.move_ip(self.player_speed, 0)

            self.ball.move_ip(*self.ball_speed)
            if self.ball.left <= 0 or self.ball.right >= SCREEN_WIDTH:
                self.ball_speed[0] = -self.ball_speed[0]
            if self.ball.top <= 0 or self.ball.bottom >= SCREEN_HEIGHT:
                return
            if self.ball.colliderect(self.player) or self.ball.colliderect(self.opponent):
                self.ball_speed[1] = -self.ball_speed[1]

            self.opponent.centerx = self.ball.centerx

            self.screen.fill(WHITE)
            pygame.draw.ellipse(self.screen, GREEN, self.ball)
            pygame.draw.rect(self.screen, BLUE, self.player)
            pygame.draw.rect(self.screen, RED, self.opponent)
            pygame.display.flip()
            self.clock.tick(60)

class Game4:
    """
    Game 4: Single Player Walking. A player (square) moves around the screen, bounded by the screen edges.
    """
    def __init__(self, screen):
        self.screen = screen
        self.clock = pygame.time.Clock()
        self.player = pygame.Rect(375, 275, 50, 50)  # A square player
        self.player_speed = 5
        self.teleport_enabled = False
        self.teleport_timer = 0
        self.teleport_cooldown = 2000

    def run(self):
        """
        Main loop for Game 4.
        """
        while True:
            # Handle events: here is where you need to code!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            for event in pygame.event.get(): 
                if (event.type == pygame.QUIT): return

            keys = pygame.key.get_pressed()
            if (keys[pygame.K_SPACE]): 
                print("Space key pressed! (Teleport enabled)")
            if keys[pygame.K_LEFT]:
                print("Left key pressed! (Move left)")
            if keys[pygame.K_RIGHT]:
                print("Right key pressed! (Move right)")
            if keys[pygame.K_UP]:
                print("Up key pressed! (Move up)")
            if keys[pygame.K_DOWN]:
                print("Down key pressed! (Move down)")
            if keys[pygame.K_ESCAPE]: 
                print("Escape key pressed! (Exit)")



            if keys[pygame.K_LEFT] and self.player.left > 0: 
                self.player.move_ip(-self.player_speed, 0)
            if keys[pygame.K_RIGHT] and self.player.right < SCREEN_WIDTH: 
                self.player.move_ip(self.player_speed, 0)
            if keys[pygame.K_UP] and self.player.top > 0: 
                self.player.move_ip(0, -self.player_speed)
            if keys[pygame.K_DOWN] and self.player.bottom < SCREEN_HEIGHT: 
                self.player.move_ip(0, self.player_speed)

            self.screen.fill(WHITE)
            pygame.draw.rect(self.screen, BLUE, self.player)
            pygame.display.flip()
            self.clock.tick(60)


def main():
    """
    Main function to run the application.
    """
    menu_view = MenuView(screen)
    menu_controller = MenuController(menu_view)

    while True:
        selected_game = menu_controller.run()
        if selected_game == 0:
            Game1(screen).run()
        elif selected_game == 1:
            Game2(screen).run()
        elif selected_game == 2:
            Game3(screen).run()
        elif selected_game == 3:
            Game4(screen).run()


if __name__ == "__main__":
    main()