import pygame
from pygame.locals import QUIT
from random import randint

pygame.init()


screen = pygame.display.set_mode( (800, 600), 0, 32)

# input("TECLE <ENTER> PARA ENCERRAR")

# Processo do Jogo
sair = False
while not sair:
    # Calcular regras

    # Mostrar imagens na Tela

    # Desenha varios pixels coloridos na tela
    # for y in range(10, 590):
    #     for x in range(10, 790):
    #         red = randint(0, 255)
    #         green = randint(0,255)
    #         blue = randint(0, 255)
    #         screen.set_at( (x, y), (red, green, blue) )
    
    screen.fill((0, 0, 0))

    for i in range(100):
        x = randint(10, 790)
        y = randint(10, 590)
        largura = randint(10, 400)
        altura = randint(10, 300)
        red = randint(0, 255)
        green = randint(0,255)
        blue = randint(0, 255)
        pygame.draw.rect(screen, (red, green, blue),
            #              x  y    largura   altura
                        ( (x, y), (largura,  altura) ),
                        0 # expessura traço
                        )

    # Atualiza a tela com base nos dados do Buffer
    pygame.display.update()
    
    # Capturar os eventos do usuario
    for event in pygame.event.get():
        if event.type == QUIT:
            sair = True

