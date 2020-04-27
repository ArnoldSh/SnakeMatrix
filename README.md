# SnakeMatrix
Реализация алгоритма, который заполняет двумерный массив натуральными числами от 1 до n^2 в форме "змейки" / "спирали" по часовой стрелке.

Пример, для n = 5:

1      2      3      4      5      
16     17     18     19     6      
15     24     25     20     7      
14     23     22     21     8      
13     12     11     10     9

Данная реализация мне показалось интересной, т.к. в таком решении я обнаружил интересное свойство квадрата натурального числа (n^2 = n + 2*(n-1) + 2*(n-2) + ... + 2(n-(n-2)) + 2*(n-(n-1))) и геометрическую интепретацию данного свойства в виде той самой "змейки" / "спирали", которую по задаче требуется нарисовать.
