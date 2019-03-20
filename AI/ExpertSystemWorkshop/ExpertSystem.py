from pyknow import *
from random import choice

class Ground(Fact):
    pass

class Drools(KnowledgeEngine):

    @Rule(Ground(ph=L(7.2)))
    def ask_ph(self):
        print("==> ph: ALCALINO")
    
    # @Rule(AND(Ground(ph>6.8),Ground(ph<=7.2)))
    # def ask_cd(self):
    #     print("==> ph: LIGERAMENTE ALCALINO")
    
    # @Rule(AND(Ground(ph <= 6.8),Ground(ph > 6.2)))
    # def ask_gt(self):
    #     print("==> ph: NEUTRO")

engine = Drools()
engine.reset()
engine.declare(Ground(ph=choice([7.2, 7.2, 7.2])))
engine.run()

