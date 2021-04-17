chomp :: String -> String
chomp str = takeWhile (== head str) str

munch :: String -> String
munch = take 9 . chomp

runs :: String -> [String]
runs "" = []
runs str = extract str [] where
    extract str xs
        |   length str == 0 = xs
        |   otherwise = extract (drop (length (munch str)) str) (xs ++ [(munch str)])

encode :: String -> [(Char,Int)]
encode [] = []
encode str  = ((x !! 0),(length x)):(encode (drop (length x) (str)))
    where (x:xs) = runs str

flatten :: [(Char,Int)] -> String
flatten [] = []
flatten (x:xs) = (fst x):(show (snd x) ++ flatten xs)

compress [] = []
compress str = flatten (encode str)

decode :: [(Char,Int)] -> String
decode [] = []
decode (x:xs) = ((take (snd x) (repeat (fst x)))) ++ decode xs

expand :: String -> [(Char,Int)]
expand [] = []
expand [x] = []
expand (x:y:xs) = (x,(fromEnum y - fromEnum '0')):(expand xs)

decompress :: String -> String
decompress [] = []
decompress str = decode (expand str)