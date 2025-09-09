#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
French Flashcards — a simple Pygame flashcard app

UI / UX flow implemented:
1. Show a French word centered, with an "Answer" button at the bottom.
2. When the Answer button (or Space) is pressed, show the English translation
   and the button text becomes "Next".
3. When Next is pressed, advance to the next card. When all cards have been
   shown, the deck is reshuffled and the cycle continues.

Behavior:
- The order is randomized at app start and after every full pass through the deck.
- You can also use SPACE to reveal/advance.
- Click the button with the mouse to reveal/advance.
"""

import random
import pygame
import sys

# ----------------------------
# Configuration / Constants
# ----------------------------
SCREEN_WIDTH = 1000
SCREEN_HEIGHT = 700
SCREEN_CAPTION = "French Flashcards"

FPS = 60

# Colors (R, G, B)
WHITE = (255, 255, 255)
BLACK = (15, 15, 20)
PANEL = (30, 30, 40)
BUTTON = (70, 130, 180)
BUTTON_HOVER = (90, 150, 200)
TEXT_COLOR = (240, 240, 245)
ACCENT = (220, 90, 90)


EN_TO_FR_FROM_TEXTBOOK = {
    # general
    "greetings": "les salutations",
    "for meeting someone": "pour faire la connaissance",

    # titles
    "mrs.": "Madame",
    "miss": "Mademoiselle",
    "ms.": "Mademoiselle",
    "mr.": "Monsieur",

    # thanks / responses
    "thank you": "merci",
    "you're welcome": "de rien",
    "you're welcome (inf.)": "je t'en prie",
    "you're welcome (formal)": "je vous en prie",
    "you're welcome (alt)": "il n'y a pas de quoi",
    "it's not a big deal": "ce n'est pas grand-chose",
    "it's not a big deal (literal)": "ce n'est pas une grande chose",

    # basic greetings
    "hello": "bonjour",
    "hello (daytime)": "bonjour",
    "hello (nighttime)": "bonsoir",
    "hi": "salut",
    "ciao (informal)": "ciao",
    "bye": "au revoir",
    "bye (informal)": "salut / ciao",
    "goodbye": "au revoir",

    # see you / parting phrases
    "see you tomorrow": "à demain",
    "see you later": "à plus tard",
    "see you later (short)": "à tout à l'heure",
    "see you soon": "à bientôt",
    "see you next time": "à la prochaine",
    "have a good day": "bonne journée",
    "have a good evening / enjoy your evening": "bonne soirée",
    "good night": "bonne nuit",

    
    # see you / parting phrases
    "see you tomorrow": "à demain",
    "see you later": "à plus tard",
    "see you later (short)": "à tout à l'heure",
    "see you soon": "à bientôt",
    "see you next time": "à la prochaine",
    "have a good day": "bonne journée",
    "have a good evening / enjoy your evening": "bonne soirée",
    "good night": "bonne nuit",

    # introductions / names
    "what's your name (informal)": "comment t'appelles-tu ?",
    "what's your name (formal / plural)": "comment vous appelez-vous ?",
    "my name is": "je m'appelle",
    "nice to meet you (m./f.)": "enchanté(e)",

    # how are you / responses
    "how's it going?": "comment ça va ?",
    "it's going ok": "ça va.",
    "very well": "très bien",
    "badly": "mal",
    "not bad": "pas mal",
    "not bad at all": "pas mal du tout",
    "so-so": "comme ci, comme ça",
    "how are you (friend)": "comment vas-tu ?",
    "how are you (adult/group)": "comment allez-vous ?",
    "i'm doing well": "je vais bien.",

    # introducing someone / this is...
    "this is": "voici / c'est",
    "this is (i'd like to introduce you to) (inf.)": "je te présente",
    "this is (i'd like to introduce you to) (form.)": "je vous présente",

    "madame (mme)": "Madame (Mme)",
    "monsieur (m.)": "Monsieur (M.)",
    "mademoiselle (mlle)": "Mademoiselle (Mlle)",

    "yes / no": "Oui / Non",
    "please": "S'il vous plaît / S'il te plaît",
    "thank you": "Merci",
    "you're welcome": "De rien / Je vous en prie / Je t'en prie / Il n'y a pas de quoi",

    "excuse me": "Excusez-moi",
    "pardon me": "Pardon",

    "how do you say ... in french?": "Comment dit-on ... en français ?",
    "one says ...": "On dit ...",
    "what does ... mean in english?": "Que veut dire ... en anglais ?",
    "it means ...": "Ça veut dire ...",
    "how do you spell ...?": "Comment s'écrit ... ?",
    "it's spelled ...": "Ça s'écrit ...",

    "do you have any questions?": "Avez-vous des questions ?",
    "i have a question": "J'ai une question",
    "i don't have a question": "Je n'ai pas de questions",

    "do you understand?": "Comprenez-vous ?",
    "i understand": "Je comprends",
    "i don't understand": "Je ne comprends pas",

    "are you done?": "Avez-vous fini ?",
    "i am finished": "J'ai fini",
    "i am not finished": "Je n'ai pas fini",

    "do you know the answer?": "Savez-vous la réponse ? / Sais-tu la réponse ?",
    "i know": "Je sais",
    "i don't know": "Je ne sais pas",

    "never mind": "Laissez tomber",
    "i forgot": "J'ai oublié",
    "i am sorry": "(Je suis) désolé(e)",

    "bless you": "À tes souhaits / À vos souhaits",
    "what?": "Quoi ? / Comment ?",
    "wait, mrs. b.": "Attendez, Madame B.",
    "repeat please": "Répétez, s'il vous plaît",
    "slower": "Plus lentement",
    "one more time": "Encore une fois",

    "i have a problem": "J'ai un problème.",

    "can i go...?": "Est-ce que je peux aller... ?",
    "to the bathroom?": "aux toilettes ?",
    "to the water fountain?": "à la fontaine ?",
    "to my locker?": "à mon casier ?",
    "to the clinic?": "à l'infirmerie ?",

    "may i have... some tape? a band-aid?": "Puis-je avoir du ruban ? / un pansement ?",

    "may i use... the hole puncher / scissors / stapler?": "Puis-je utiliser la perforatrice / les ciseaux / l'agrafeuse ?",

    "i need... some help / some paper / a pencil": "J'ai besoin d'aide / de papier / d'un crayon",

    "what's that?": "Qu'est-ce que c'est ?",
    "it's a ...": "C'est un/une ...",
    "those are some ...": "Ce sont des ...",

    "where is the pencil sharpener?": "Où est le taille-crayon ?",
    "where are the bathrooms?": "Où sont les toilettes ?",
    "where is the absent folder?": "Où est le dossier d'absence ?",

    "awesome!": "Formidable ! / Génial !",
    "extra (cool)": "Extra !",
    "magnificent!": "Magnifique !",
    "neat!": "Chouette !",
    "super!": "Super !",
    "terrific!": "Fantastique !",
    "wonderful!": "Merveilleux !",
    "darn it!": "Zut alors !",
    "good try": "Bien essayé ! / Bon essai !",
    "good work": "Beau travail ! / Bon travail !",



    
    "go to the board": "Allez au tableau",
    "stop talking": "Arrêtez de parler",
    "sit down": "Asseyez-vous",
    "wait": "Attendez",
    "move": "Bougez",
    "sing (the song)": "Chantez (la chanson)",
    "get up": "Levez-vous",
    "get the book from the shelf": "Prenez le livre sur l'étagère",
    "continue": "Continuez",
    "clear off the table": "Dégagez la table",
    "draw": "Dessinez",
    "tell me the truth": "Dites-moi la vérité",
    "listen to me": "Écoutez-moi",
    "write your name / the homework": "Écrivez (votre nom / les devoirs)",

    "enter the classroom": "Entrez dans la salle de classe",
    "study": "Étudiez",
    "pay attention / do the work": "Faites attention / Faites le travail",
    "close the door": "Fermez la porte",
    "finish": "Finissez",
    "play the game": "Jouez au jeu",
    "throw away trash in the can": "Jetez les ordures dans la poubelle",
    "raise your hand": "Levez la main",
    "read the sentence on the board": "Lisez la phrase au tableau",
    "put the water bottle on the ground": "Mettez la bouteille d'eau sur le sol",
    "organize your papers": "Organisez vos papiers",


    "open the book": "Ouvrez le livre",
    "speak in french": "Parlez en français",
    "think": "Pensez",
    "ask the question": "Posez la question / Demandez la question",
    "get ready to leave": "Préparez-vous à quitter",
    "leave the classroom": "Quittez la salle de classe",
    "clean the classroom": "Rangez la salle de classe",
    "refer to your notes": "Référez-vous aux notes",
    "look at the board": "Regardez le tableau",
    "put back your chairs": "Remettez vos chaises",
    "fill in the blanks": "Remplissez les trous",
    "put the pencil on the desk": "Mettez le crayon sur le bureau",
    "turn in the hwk": "Rendez les devoirs",
    "repeat after me": "Répétez après moi",
    "answer the question": "Répondez à la question",
    "review": "Révisez",
    "take out some paper": "Sortez du papier",
    "be quiet please": "Soyez silencieux, s'il vous plaît",
    "be calm": "Soyez tranquilles",
    "be productive": "Soyez productifs",
    "be creative": "Soyez créatifs",
    "be kind": "Soyez gentils",
    "work well": "Travaillez bien",
    "negative verb formula (consonant)": "NE + verbe commençant par consonne + PAS (ex : Ne regardez pas les notes !)",
    "negative verb formula (vowel)": "NE + verbe commençant par voyelle + PAS (ex : N'écrivez pas sur la table !)",
}









# ----------------------------
# Vocabulary (English -> French)
# ----------------------------
# You can expand or replace this dictionary with any pairs you want.
EN_TO_FR = {
    # "cat": "chat",
    # "dog": "chien",
    # "house": "maison",
    # "book": "livre",
    # "water": "eau",
    # "food": "nourriture",
    # "school": "école",
    # "car": "voiture",
    # "friend": "ami",
    # "family": "famille",
    # "love": "amour",
    # "good": "bon / bonne",
    # "bad": "mauvais / mauvaise",
    # "happy": "heureux / heureuse",
    # "sad": "triste",
    # "apple": "pomme",
    # "bread": "pain",
    # "cheese": "fromage",
    # "city": "ville",
    # "work": "travail",
    # "today": "aujourd'hui",
    # "tomorrow": "demain",
    # "morning": "matin",
    # "night": "nuit",
    # "Good Night":"Bonne nuit",
    # "please": "s'il vous plaît",
    # "thank you": "merci",
    # "sorry": "désolé(e)",
    # "yes": "oui",
    # "no": "non",
    # "excuse me": "excusez-moi",
    # "GoodBye":"Au Revoir",
    # "See you tommorrow":"A Demain",
    # "greetings": "les salutations",
    





    # general
    "greetings": "les salutations",
    "for meeting someone": "pour faire la connaissance",

    # titles
    "mrs.": "Madame",
    "miss": "Mademoiselle",
    "ms.": "Mademoiselle",
    "mr.": "Monsieur",

    # thanks / responses
    "thank you": "merci",
    "you're welcome": "de rien",
    "you're welcome (inf.)": "je t'en prie",
    "you're welcome (formal)": "je vous en prie",
    "you're welcome (alt)": "il n'y a pas de quoi",
    "it's not a big deal": "ce n'est pas grand-chose",
    "it's not a big deal (literal)": "ce n'est pas une grande chose",

    # basic greetings
    "hello": "bonjour",
    "hello (daytime)": "bonjour",
    "hello (nighttime)": "bonsoir",
    "hi": "salut",
    "bye": "au revoir",
    "bye (informal)": "salut / ciao",
    "goodbye": "au revoir",

    # see you / parting phrases
    "see you tomorrow": "à demain",
    "see you later": "à plus tard",
    "see you later (short)": "à tout à l'heure",
    "see you soon": "à bientôt",
    "see you next time": "à la prochaine",
    "have a good day": "bonne journée",
    "have a good evening / enjoy your evening": "bonne soirée",
    "good night": "bonne nuit",

    
    # see you / parting phrases
    "see you tomorrow": "à demain",
    "see you later": "à plus tard",
    "see you later (short)": "à tout à l'heure",
    "see you soon": "à bientôt",
    "see you next time": "à la prochaine",
    "have a good day": "bonne journée",
    "have a good evening / enjoy your evening": "bonne soirée",
    "good night": "bonne nuit",

    # introductions / names
    "what's your name (informal)": "comment t'appelles-tu ?",
    "what's your name (formal / plural)": "comment vous appelez-vous ?",
    "my name is": "je m'appelle",
    "nice to meet you (m./f.)": "enchanté(e)",

    # how are you / responses
    "how's it going?": "comment ça va ?",
    "it's going ok": "ça va.",
    "very well": "très bien",
    "badly": "mal",
    "not bad": "pas mal",
    "not bad at all": "pas mal du tout",
    "so-so": "comme ci, comme ça",
    "how are you (friend)": "comment vas-tu ?",
    "how are you (adult/group)": "comment allez-vous ?",
    "i'm doing well": "je vais bien.",

    # introducing someone / this is...
    "this is": "voici / c'est",
    "this is (i'd like to introduce you to) (inf.)": "je te présente",
    "this is (i'd like to introduce you to) (form.)": "je vous présente",

    "madame (mme)": "Madame (Mme)",
    "monsieur (m.)": "Monsieur (M.)",
    "mademoiselle (mlle)": "Mademoiselle (Mlle)",

    "yes / no": "Oui / Non",
    "please": "S'il vous plaît / S'il te plaît",
    "thank you": "Merci",
    "you're welcome": "De rien / Je vous en prie / Je t'en prie / Il n'y a pas de quoi",

    "excuse me": "Excusez-moi",
    "pardon me": "Pardon",

    "how do you say ... in french?": "Comment dit-on ... en français ?",
    "one says ...": "On dit ...",
    "what does ... mean in english?": "Que veut dire ... en anglais ?",
    "it means ...": "Ça veut dire ...",
    "how do you spell ...?": "Comment s'écrit ... ?",
    "it's spelled ...": "Ça s'écrit ...",

    "do you have any questions?": "Avez-vous des questions ?",
    "i have a question": "J'ai une question",
    "i don't have a question": "Je n'ai pas de questions",

    "do you understand?": "Comprenez-vous ?",
    "i understand": "Je comprends",
    "i don't understand": "Je ne comprends pas",

    "are you done?": "Avez-vous fini ?",
    "i am finished": "J'ai fini",
    "i am not finished": "Je n'ai pas fini",

    "do you know the answer?": "Savez-vous la réponse ? / Sais-tu la réponse ?",
    "i know": "Je sais",
    "i don't know": "Je ne sais pas",

    "never mind": "Laissez tomber",
    "i forgot": "J'ai oublié",
    "i am sorry": "(Je suis) désolé(e)",

    "bless you": "À tes souhaits / À vos souhaits",
    "what?": "Quoi ? / Comment ?",
    "wait, mrs. b.": "Attendez, Madame B.",
    "repeat please": "Répétez, s'il vous plaît",
    "slower": "Plus lentement",
    "one more time": "Encore une fois",

    "i have a problem": "J'ai un problème.",

    "can i go...?": "Est-ce que je peux aller... ?",
    "to the bathroom?": "aux toilettes ?",
    "to the water fountain?": "à la fontaine ?",
    "to my locker?": "à mon casier ?",
    "to the clinic?": "à l'infirmerie ?",

    "may i have... some tape? a band-aid?": "Puis-je avoir du ruban ? / un pansement ?",

    "may i use... the hole puncher / scissors / stapler?": "Puis-je utiliser la perforatrice / les ciseaux / l'agrafeuse ?",

    "i need... some help / some paper / a pencil": "J'ai besoin d'aide / de papier / d'un crayon",

    "what's that?": "Qu'est-ce que c'est ?",
    "it's a ...": "C'est un/une ...",
    "those are some ...": "Ce sont des ...",

    "where is the pencil sharpener?": "Où est le taille-crayon ?",
    "where are the bathrooms?": "Où sont les toilettes ?",
    "where is the absent folder?": "Où est le dossier d'absence ?",

    "awesome!": "Formidable ! / Génial !",
    "extra (cool)": "Extra !",
    "magnificent!": "Magnifique !",
    "neat!": "Chouette !",
    "super!": "Super !",
    "terrific!": "Fantastique !",
    "wonderful!": "Merveilleux !",
    "darn it!": "Zut alors !",
    "good try": "Bien essayé ! / Bon essai !",
    "good work": "Beau travail ! / Bon travail !",



    
    "go to the board": "Allez au tableau",
    "stop talking": "Arrêtez de parler",
    "sit down": "Asseyez-vous",
    "wait": "Attendez",
    "move": "Bougez",
    "sing (the song)": "Chantez (la chanson)",
    "get up": "Levez-vous",
    "get the book from the shelf": "Prenez le livre sur l'étagère",
    "continue": "Continuez",
    "clear off the table": "Dégagez la table",
    "draw": "Dessinez",
    "tell me the truth": "Dites-moi la vérité",
    "listen to me": "Écoutez-moi",
    "write your name / the homework": "Écrivez (votre nom / les devoirs)",

    "enter the classroom": "Entrez dans la salle de classe",
    "study": "Étudiez",
    "pay attention / do the work": "Faites attention / Faites le travail",
    "close the door": "Fermez la porte",
    "finish": "Finissez",
    "play the game": "Jouez au jeu",
    "throw away trash in the can": "Jetez les ordures dans la poubelle",
    "raise your hand": "Levez la main",
    "read the sentence on the board": "Lisez la phrase au tableau",
    "put the water bottle on the ground": "Mettez la bouteille d'eau sur le sol",
    "organize your papers": "Organisez vos papiers",


    "open the book": "Ouvrez le livre",
    "speak in french": "Parlez en français",
    "think": "Pensez",
    "ask the question": "Posez la question / Demandez la question",
    "get ready to leave": "Préparez-vous à quitter",
    "leave the classroom": "Quittez la salle de classe",
    "clean the classroom": "Rangez la salle de classe",
    "refer to your notes": "Référez-vous aux notes",
    "look at the board": "Regardez le tableau",
    "put back your chairs": "Remettez vos chaises",
    "fill in the blanks": "Remplissez les trous",
    "put the pencil on the desk": "Mettez le crayon sur le bureau",
    "turn in the hwk": "Rendez les devoirs",
    "repeat after me": "Répétez après moi",
    "answer the question": "Répondez à la question",
    "review": "Révisez",
    "take out some paper": "Sortez du papier",
    "be quiet please": "Soyez silencieux, s'il vous plaît",
    "be calm": "Soyez tranquilles",
    "be productive": "Soyez productifs",
    "be creative": "Soyez créatifs",
    "be kind": "Soyez gentils",
    "work well": "Travaillez bien",
    # "negative verb formula (consonant)": "NE + verbe commençant par consonne + PAS (ex : Ne regardez pas les notes !)",
    # "negative verb formula (vowel)": "NE + verbe commençant par voyelle + PAS (ex : N'écrivez pas sur la table !)",
}

# ----------------------------
# Helper UI classes / funcs
# ----------------------------

class Button:
    def __init__(self, rect, text, font, base_color=BUTTON, hover_color=BUTTON_HOVER, radius=10):
        self.rect = pygame.Rect(rect)
        self.text = text
        self.font = font
        self.base_color = base_color
        self.hover_color = hover_color
        self.radius = radius

    def draw(self, surf, mouse_pos):
        is_hover = self.rect.collidepoint(mouse_pos)
        color = self.hover_color if is_hover else self.base_color
        pygame.draw.rect(surf, color, self.rect, border_radius=self.radius)
        # text
        text_surf = self.font.render(self.text, True, TEXT_COLOR)
        text_rect = text_surf.get_rect(center=self.rect.center)
        surf.blit(text_surf, text_rect)

    def clicked(self, mouse_pos, mouse_pressed):
        return mouse_pressed[0] and self.rect.collidepoint(mouse_pos)


def center_text(surf, text, font, y, color=TEXT_COLOR, max_width=None):
    """Render text centered horizontally at y. Optionally wrap if too wide."""
    if max_width is None:
        txt_surf = font.render(text, True, color)
        rect = txt_surf.get_rect(center=(SCREEN_WIDTH // 2, y))
        surf.blit(txt_surf, rect)
    else:
        # simple wrap by splitting words (very light-weight)
        words = text.split()
        line = ""
        lines = []
        for w in words:
            test = (line + " " + w).strip()
            if font.size(test)[0] <= max_width:
                line = test
            else:
                lines.append(line)
                line = w
        if line:
            lines.append(line)
        # draw lines
        h = font.get_linesize()
        start_y = y - (h * len(lines)) // 2
        for i, ln in enumerate(lines):
            txt_surf = font.render(ln, True, color)
            rect = txt_surf.get_rect(center=(SCREEN_WIDTH // 2, start_y + i * h))
            surf.blit(txt_surf, rect)


# ----------------------------
# Flashcard logic
# ----------------------------

class FlashcardDeck:
    def __init__(self, en_to_fr: dict):
        """
        internal representation: list of tuples (english, french)
        We will show french first, then reveal english.
        """
        self.pairs = list((en, fr) for en, fr in en_to_fr.items())
        self.shuffle_deck()
        self.index = 0

    def shuffle_deck(self):
        random.shuffle(self.pairs)
        self.index = 0

    def current(self):
        """Return (english, french) of current card"""
        if not self.pairs:
            return ("", "")
        return self.pairs[self.index]

    def advance(self):
        """Move to next card; reshuffle if finished."""
        self.index += 1
        if self.index >= len(self.pairs):
            self.shuffle_deck()

    def progress_text(self):
        if not self.pairs:
            return "0 / 0"
        return f"{self.index + 1} / {len(self.pairs)}"


# ----------------------------
# Main App
# ----------------------------

def main():
    pygame.init()
    screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
    pygame.display.set_caption(SCREEN_CAPTION)
    clock = pygame.time.Clock()

    # Fonts
    title_font = pygame.font.SysFont(None, 46)
    word_font = pygame.font.SysFont(None, 96)
    sub_font = pygame.font.SysFont(None, 28)
    btn_font = pygame.font.SysFont(None, 36)

    # Deck: english -> french but UI shows french first
    deck = FlashcardDeck(EN_TO_FR)

    # Button at bottom center
    btn_w, btn_h = 220, 60
    btn_x = (SCREEN_WIDTH - btn_w) // 2
    btn_y = SCREEN_HEIGHT - btn_h - 40
    action_button = Button((btn_x, btn_y, btn_w, btn_h), "Answer", btn_font)

    show_answer = False  # False: show french; True: show english + "Next" button
    running = True

    # Subtle initial randomization already done by FlashcardDeck

    while running:
        mouse_pos = pygame.mouse.get_pos()
        mouse_pressed = pygame.mouse.get_pressed()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False

            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_ESCAPE:
                    running = False
                elif event.key == pygame.K_SPACE:
                    # SPACE toggles reveal/advance like clicking the button
                    if not show_answer:
                        show_answer = True
                        action_button.text = "Next"
                    else:
                        deck.advance()
                        show_answer = False
                        action_button.text = "Answer"

            elif event.type == pygame.MOUSEBUTTONDOWN:
                # Handled by checking button.clicked below to avoid double reads
                pass

        # Button click handling (use mouse_pressed to allow both click+hold and immediate press)
        if action_button.clicked(mouse_pos, mouse_pressed):
            # simple debounce: wait for mouse release (handled by frame ticks) but this is OK for demo.
            if not show_answer:
                show_answer = True
                action_button.text = "Next"
            else:
                deck.advance()
                show_answer = False
                action_button.text = "Answer"

        # Draw background
        screen.fill(PANEL)

        # Top Title / Instructions
        title_text = "French Flashcards — Press SPACE to Reveal/Next, ESC to Quit"
        title_surf = title_font.render(title_text, True, TEXT_COLOR)
        screen.blit(title_surf, (30, 18))

        # Card Panel
        panel_w, panel_h = SCREEN_WIDTH - 120, SCREEN_HEIGHT - 220
        panel_x, panel_y = 60, 80
        pygame.draw.rect(screen, BLACK, (panel_x, panel_y, panel_w, panel_h), border_radius=12)
        # inner area for the word
        inner_pad = 24
        inner_rect = pygame.Rect(panel_x + inner_pad, panel_y + inner_pad,
                                 panel_w - 2 * inner_pad, panel_h - 2 * inner_pad)
        pygame.draw.rect(screen, (20, 24, 30), inner_rect, border_radius=8)

        # Current card
        eng, fr = deck.current()

        # Positioning for words
        word_y = panel_y + panel_h // 2 - 40

        # Show French first
        center_text(screen, fr, word_font, word_y, color=TEXT_COLOR, max_width=inner_rect.width - 40)

        # If revealed, show English underneath in smaller font
        if show_answer:
            # Draw a subtle separator
            sep_y = word_y + 70
            pygame.draw.line(screen, (60, 66, 80), (inner_rect.left + 40, sep_y), (inner_rect.right - 40, sep_y), 2)
            center_text(screen, eng, sub_font, sep_y + 36, color=ACCENT, max_width=inner_rect.width - 80)

        # Progress indicator top-right of panel
        progress_text = deck.progress_text()
        prog_surf = sub_font.render(progress_text, True, TEXT_COLOR)
        prog_rect = prog_surf.get_rect(topright=(panel_x + panel_w - 16, panel_y + 18))
        screen.blit(prog_surf, prog_rect)

        # Draw the button
        action_button.draw(screen, mouse_pos)

        # Helpful hint above button
        hint = "Reveal the English translation" if not show_answer else "Go to next card"
        hint_surf = sub_font.render(hint, True, TEXT_COLOR)
        hint_rect = hint_surf.get_rect(center=(SCREEN_WIDTH // 2, btn_y - 18))
        screen.blit(hint_surf, hint_rect)

        # Footer credit
        footer = "Built with Pygame — edit the EN_TO_FR dictionary to add/change cards"
        footer_surf = sub_font.render(footer, True, (140, 140, 150))
        screen.blit(footer_surf, (30, SCREEN_HEIGHT - 28))

        # Flip / Tick
        pygame.display.flip()
        clock.tick(FPS)

    pygame.quit()
    sys.exit()


if __name__ == "__main__":
    main()


# """
# A basic PyGame setup that displays a movable rectangle.

# This script initializes PyGame, creates a window, and runs a simple game
# loop. The player controls a blue rectangle with the arrow keys. All PyGame
# events are printed to the console for educational purposes.
# """

# import pygame


# # Variable 
# SCREEN_WIDTH = 1900                     # int variable (constant)
# SCREEN_HEIGHT = 1080                    # int variable (constant)
# SCREEN_CAPTION = "Abyss of Darkness"    # str variable (constant)

# # --- Colors ---
# # Define colors using RGB tuples for easy reference. (Red, Green, Blue)
# WHITE = (255, 255, 255)
# BLUE = (0, 0, 255)
# BLACK = (0, 0, 0)
# RED = (255,0,0)
# GREEN = (0,255,0)



# # --- Game Objects ---
# # Create a pygame.Rect object for our player.
# # The arguments are (left, top, width, height).
# # We start it in the center of the screen.
# player_rect = pygame.Rect((SCREEN_WIDTH / 2) - 25, (SCREEN_HEIGHT / 2) - 25, 50, 50)
# player_speed = 5 # highlights, short: how many pixels the rect moves per frame










# def main():
#     """Main function to run the PyGame application."""
#     # --- Initialization ---
#     # Initialize all imported pygame modules
#     pygame.init()

#     # --- Screen Setup ---
#     # Informative notes, long:
#     # We define the screen dimensions here. It's good practice to use
#     # constants for these values so they can be easily changed and referenced
#     # elsewhere in the code without using "magic numbers".
#     screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
#     pygame.display.set_caption(SCREEN_CAPTION)



#     # --- Game Loop ---
#     # The clock will be used to control the game's frame rate.
#     clock = pygame.time.Clock()
    
#     running = True # 1
#     while running:
#         # --- Event Handling ---
#         # This is the core of the event loop. Pygame processes user input
#         # (like key presses, mouse movements, etc.) as a series of events.
#         # We iterate through each event that has happened since the last frame.
#         for event in pygame.event.get():
#             # Print the full event object to the console.
#             # This is useful for learning what different actions generate.
#             print(event)

#             # Check if the event is the user clicking the window's close button.
#             if event.type == pygame.QUIT: running = False # highlights, short: exits the loop

#         # --- Player Movement ---
#         # Get a dictionary of all keyboard keys currently being held down.
#         keys_pressed = pygame.key.get_pressed()

#         # Update the player's x-coordinate based on arrow key presses.
#         if keys_pressed[pygame.K_LEFT]:
#             player_rect.x -= player_speed
#         if keys_pressed[pygame.K_RIGHT]:
#             player_rect.x += player_speed

#         # Update the player's y-coordinate based on arrow key presses.
#         if keys_pressed[pygame.K_UP]:
#             player_rect.y -= player_speed
#         if keys_pressed[pygame.K_DOWN]:
#             player_rect.y += player_speed

#         # --- Screen Boundaries ---
#         # This logic prevents the rectangle from moving off the screen.
#         if player_rect.left < 0:
#             player_rect.left = 0
#         if player_rect.right > SCREEN_WIDTH:
#             player_rect.right = SCREEN_WIDTH
#         if player_rect.top < 0:
#             player_rect.top = 0
#         if player_rect.bottom > SCREEN_HEIGHT:
#             player_rect.bottom = SCREEN_HEIGHT

#         # --- Drawing ---
#         # First, fill the screen with a background color (black).
#         # This is done on each frame to clear the previous frame's drawings.
#         screen.fill(BLACK)

#         # Draw the player rectangle onto the screen surface.
#         pygame.draw.rect(screen, GREEN, player_rect)

#         # --- Update Display ---
#         # This function updates the contents of the entire screen. It's the
#         # final step in the drawing process for each frame.
#         pygame.display.flip()

#         # --- Frame Rate Control ---
#         # This will pause the game for a short amount of time to ensure that
#         # the loop runs at a maximum of 60 frames per second.
#         clock.tick(60)

#     # --- Shutdown ---
#     # Once the `running` variable is False, the loop ends.
#     # We call pygame.quit() to uninitialize the modules.
#     pygame.quit()
#     print("PyGame has been shut down.")
















# if __name__ == "__main__":
#     main() # main is where your program starts.