import pygame
from pygame.locals import QUIT

pygame.init()

screen = pygame.display.set_mode((800, 600), 0, 32)

sair = False
while not sair:

    # Regras

    # Imagem
    altura_maxima = 300
    largura_maxima = 400
    screen.fill( (0, 0, 0) )

    for i in range(10):
        altura = 30 * (i + 1)
        deslocamento = altura // 2
        y = altura_maxima - (100 + deslocamento)
        pygame.draw.ellipse(screen, (255, 255, 0),
                           ( (100, y), (400, altura) ), 3 )
        
    for i in range(10):
        largura = 40 * (i + 1)
        deslocamento = largura // 2
        x = largura_maxima - (100 + deslocamento)
        pygame.draw.ellipse(screen, (255, 255, 0),
                           ( (x, y), (largura, altura) ), 3 )
    
    pygame.display.update()

    # Eventos
    for event in pygame.event.get():
        if event.type == QUIT:
            sair = True
