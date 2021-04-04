
factors :: Int -> [Int]
factors n =
    [x | x <- [1..n],  mod n x == 0]

perfect :: Int -> Bool 
perfect n = sum (init (factors n)) == n

perfects :: Int -> [Int]
perfects n = [x | x <- [1..n], perfect x]

fac :: Int -> Int 
fac n = product [1..n]

replicate1 :: Int -> a-> [a]
replicate1 0 x = []
replicate1 n x = x : replicate1 (n-1) x

(!!!) :: [a] -> Int -> a
(x:_) !!! 0 = x
(_:xs) !!! n = xs !!! (n-1)

insert :: Int -> [Int] -> [Int]
insert x [] = [x]
insert x (y:ys) = if x <= y then
                    x:y:ys
                    else
                        y:insert x ys

merge :: [Int] -> [Int] -> [Int]
merge [] ys = ys
merge xs [] = xs
merge (x:xs) (y:ys) = if x <= y then
                        x : merge xs (y:ys)
                        else
                            y : merge (x:xs) ys

-- msort :: [Int] -> [Int]
-- msort [] = []
-- msort [x] = [x]
-- msort xs = merge (msort ys) (msort zs)
--             where (ys,zs) = halve xs
