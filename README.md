# SnakeMatrix
Реализация алгоритма, который заполняет двумерный массив натуральными числами от 1 до n^2 в форме "змейки" / "спирали" по часовой стрелке.

Пример, для n = 5:
```
1      2      3      4      5      
16     17     18     19     6      
15     24     25     20     7      
14     23     22     21     8      
13     12     11     10     9
```

Данная реализация мне показалось интересной, т.к. в таком решении я обнаружил интересное свойство квадрата натурального числа и геометрическую интепретацию данного свойства в виде той самой "змейки" / "спирали", которую по задаче требуется нарисовать.

Свойство:
```
n^2 = n + 2*(n-1) + 2*(n-2) + ... + 2(n-(n-2)) + 2*(n-(n-1))
```

Например, для n = 3 получаем следующее разложение:
```
3^2 = 3 + 2*(3-1) + 2*(3-2) = 3 + 2*2 + 2 = 3 + 4 + 2 = 9
```

Связь между разложением и геометрической интерпретацией "змейки" / "спирали" заключается в том, что, если последнее слагаемое (2) представить в виде суммы 1 + 1, то кол-во полученных слагаемых - это кол-во сегментов нашей змейки, а само слагаемое представляет собой длину сегмента змейки.

Используя полученные выводы, чтобы построить змейку, нужно лишь для заданного n получить такое разложение, а далее по нему рисовать змейку, используя повороты по часовой стрелке на каждый новый сегмент и вычисляя при этом новый индекс в массиве.
