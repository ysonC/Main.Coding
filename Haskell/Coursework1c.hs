--1
second1 :: [a] -> a
second1 (_:x:_) = x 

second2 :: [a] -> a
second2 (x:xs) = (x:xs) !! 1

second3 :: [a] -> a
second3 [] = error "error"
second3 (_:x:_) = x

--2
xor1 :: Bool -> Bool -> Bool 
xor1 True _ = True 
xor1 _ True = True 
xor1 False False  = False  

xor2 :: Bool -> Bool -> Bool
xor2 False False = False 

--3
sumsqr :: Int -> Int
sumsqr n = if n > 0 then
                n^2 + sumsqr (n-1)
            else
                n + 0

--4
grid :: Int -> [(Int, Int)]
grid n = [(n,n) | n <- [0..n]]

--5
euclid :: Int -> Int -> Int 
euclid a b 
           | a == b = a
           | a > b = euclid (a-b) b
           | otherwise  = euclid (b-a) a 

--6
fastrev :: [a] -> [a]
fastrev xs = rev xs []

rev :: [a] -> [a] -> [a]
rev [] ys = ys
rev (x:xs) ys = rev xs (x:ys)
