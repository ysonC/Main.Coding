import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(0, 10, 50)

plt.subplot(2, 1, 1)
plt.plot(x, np.sin(x))

plt.subplot(2, 1, 2)
plt.plot(x, np.cos(x), '+', c = 'blue')

print(x) 
#plt.savefig('figures/img-sin-cos.png')