# Cryptanalysis-of-an-extended-Vigenere-cipher.
Vigenere cipher with a non-repeating key

## Background

Recall Vigenere cipher in Lab 1. In this task your goal is to analyze and attempt to break a Running key cipher. This cipher works as Vigenere cipher, but with a key that equals in length to the plaintext. The subsection on security of the wikipedia page gives some ideas for breaking the cipher.

## Goal

Your goal is to attempt to break the following text encrypted using the running key cipher. While you might not be able to decrypt the entire text, you may be able to identify likely words or gain other partial information about the encrypted text and/or the key. Your answer for this problem should contain all approaches that you used (with reasons why you think they might work) and any partial guesses about the plaintext and the key, with justification. Here is some important information:


* Both the plaintext and the key are English texts (with punctuation, spaces, and other symbols removed, and all letters converted to lower case).

* Both the plaintext and the key are available online. The plaintext is related to the course material, the key comes from a well-known text. Both are located at the beginning of their source texts.

The problem will be graded based on the methods used, their implementation, justification for method choices, and interpretation of the results. Large amount of correctly decrypted text (with the corresponding parts of the key) will give you extra credit. Fully decrypted text (with the sources for both the text and the key) is worth 15 points extra credit. However, don't spend large amounts of time on this problem. Long runs of a program are fine, as long as they are automated and don't affect other users of the lab. Also, you are not allowed to use web crawlers of any sort in your attack or browse anyone's personal files. Browsing internet by hand is ok.

### The ciphertext to study/decrypt is as follows:

    ```
    bgogcnpldospwiuscpakimqbhgnlxukfgofpbhualuqywnllbcecwabbqleamb
    lmfyolkigwxbvrwzgksdiglkhpgwthbsyevkwlvpifstcodjeghumokuxxgfan
    raizpdlwjlshscwzgsdtxtbguudaxfvvagauqmgadwvfxegxbeeaamvgtsgefs
    ktsyfzuamanvomtvwmzrwpqcdulgbenhesjwaesjhbuttgbedqzpaazefedjtm
    fvumaghelamiugmgsqzpspkalxrzqmtttjmpaswufpvcbnimlmdyahlswympie
    zctkbymecmholuhihlmoibqevhlgssnrgplzwxmmkvvzsdeosegxlfsciiscoi
    voxtwampbwglnrvmutcmhweiikpilamprwcflajenqbrjhbscpvyrosoatpkgw
    cnmqfrufyxavafsimgqajxqrvmygbuoyhphbruogsjmxgvgtthhafxefjdchvf
    tgatrmkmesjsgbqpzvzneswqwrwxkuikqwgnxymolvvmioizdlngddhpfomxom
    whdtczhgfutnmesswmtmsyysemjddltknpfllwrvbsiqdtooygsdztpreghjin
    lamryetcjxikyqtpsitsttidvhkczilgxokiecsikweswwltltltwpziqhcmyb
    ukxuuzxrbhtzjgnrpsookmpgrwapwymwautfwpvmpbcfxhkztktovyfetylvwv
    qqwahavvswilsoiksigrvwdsyrdaqufxdsrbtbdcchtbohnqklatnbuhlgvetl
    pvtdvriyhxyxlxcyifglwyvzmppuhcfoevwecsbddjppzyexyqnwezvdmfxplp
    ofsvefrwtrqcxkiaphenzegyapdjhhplszxkmqiwxgkvzgilamjprmmrleqdrf
    bjzxagvdrqilisccdewlrpsfqpvptzgrtcpwceklemyqgnwutyfemioirvfpvd
    qiyeiulwdktdxyzvpviomiwkyomvtwtvfbflgruvdprbomamvroizftkzhvtan
    hwohgttymyeohaueiglxjvvyavfrzimeyfgkgmpdgwlsspgpeugiurwnzlrrbn
    seiedceclbsakxdmwpcivmsikprmesptjvilaavuvhvdqyvwewmmouwxtnppvw
    zakprxoiilleiyelitaowikkwzlljlthfnxpprlgibpusiowykfzutmmvczxhf
    vjvaxszrmmhzmadsgrieaxkpviqxkvklefoksuquirmrbwphneiyacacrsfrlx
    htaqhlgnsirooftzplewckytmprlpzkgpalmyussmzvayfvtnipszvunzhjxrj
    melvylnxseivgjzxqcubkgnqvbmjhgatiysnnwlbhpcwawzxaxqwcwhmgayjke
    ysieksevwunieiuudqqktalwcoifwzhdjbjwhpndesimswqtsfmipwjmqcaico
    qyovfajxtshzldlsmltxighvrqmnmoebpafeediehshvoahvnpugjippykwfwa
    biirwrhwdhzwzpyxmsidtrmqpaoijcadioxvpwfixpwlzqrohgmcjwbbhkfbua
    hpitrxlwxsaxyezcmmvjiekiawiynsfbhgteyfxjidwtkcvpvowebxpapthgbi
    oiuatemmvhbkkoreileqzamhmjprpcrgthytcbpivwyllvsovkusqxvjvwusfr
    mgsxskksnhjpslpqcubhfqyorgcaelxfazmoeutxnlkhyexeixqnrzsozelstl
    bofmpsxawftnpvthwiceseiebonakbeyraoyvzhyeymynugzzkqiltiorzxawa
    ariaxvbsgmwefshaaswkhyuoctmvtphlvgfrtbgjdjigqolrhzswvlugcfwtrf
    sgaegwhrptvslwsmmydhjrjfutgftxridwdlrlehruvalfxfuymnlnayrrxoat
    epdhlcivmsiivvmnlsukynsmvxysqdftaaqawmfzhvzzofwpnzyeglbkhvjqzn
    punghvxkhyskuhcijmjjpjvjejcwbtnliyquhrugwtwxomdythlblzlcfgceep
    bhoodpggmrjuficfmxbjocwgtgcuwgcielhsieklvgmbqtvwuggvbybwlulhwl
    quahzvfxedbgliixjwfainkfflxdpvzjlauwqgjbkrvvqkwvhtytypguuriexz
    hbpetvkxrambukbwtmrqmqtgtwqmoiluerrdllhestyqmtjdikkbvoiormjmpu
    ddrbhvvvroiekmdrigbukielhaiqfwxujtrmcakmpgvpgzyliyhxyxawbrhihm
    wllskdvwifrtswcounjtnhzgnnodweomgywnaneuuokegyobtlxzlakwwlpkzz
    fkmshiwakhgcwjjeuxiyehuxhqxtltwagjibviamwhrnlloqmniclpwiiikspv
    myssewbcsovvrauhlmdtlwflrfaemunisnpvhnylfviuebsauiqfvbtsppdqvz
    xcibdanztgupilpkdxkawskcfsdxenkgstxbybsbyxkaholpjhefsjwbehfbty
    xwjmnzdxofrwvqiicvxkmpkpqvezkgvnrejxmxqftctlskbavtdkeameglrymd
    mbohpmavjvbewtvpwiljwnyiektmjitywaeggzezsvwipxxdvlwcyqtzdwgcza
    eisibetxwdqftcfotzcsmibkqvdmxywscweelblvkmlbztygefzaedhzppoxnk
    taivjtwmrfcqnxawjvrymfoyahujhlnwmqcanzmbvqllmqdyyfxfjzwgyowzhn
    epyimcygkalzousqtwwqkxlxpvgikcneoeghuxiixtmghdnxftopcvwjsppzlu
    dptovrmqpibdzmofvbnnzattsrqkaceqscigoxxjaoxgaughbrxbnztefeeovv
    ucwrcittsetczfoampwwqktdjxbyadcneigpynsonrigtsyeiomngjjfzxtmlm
    rbpbdhgfgzmdpsekbwpwuvtkjkfqhrnpxkilnredbpzgqtpjcffwkjxjziaiuk
    sexhaljtzindftlwsxjhulxlgviroiuayevzimhwhhgsatiuevtwtbrweseqke
    ewbsolsjgkwuimdlabvfxripasnvxxtzscovihhvppxoohktkqxqmhybkwlhkr
    bagwsintofbukmlsmayievkcjmlkbqtrvzowleupossgsgqnlselxltvqzayfk
    xeiurwzpkuchhtzyeynqihzkgtrupddxyqitzshimtaqnusqtdmpsgavuidvut
    lklgluvvrevgbihtkaqqhnsgrgxhdnshcyndulrsiwbqsjpjhcllxkscpivsqp
    ladnowlnpamgovmosgzvwlugympmgjwlaetmphuaauitismhgqephwzartfdcd
    tchwbvfjqwqassekhutsjrmaiqrmqwzbtmbcudnecbhtpdhicvibprzegmavnx
    ioxvnwmjrztdrhisgkveutiqlqpgrasxkmuinmmawqkitiwiinbjmsefhrglqc
    dasgijmvvfprgbykbulkgohoscscugjlxmbehzcufnllbdqnvcfkfrnignmtke
    caaralfctenwsbphqxhrbwstmxixnajhqabumqprsxvwiaznkumloineqegcwx
    kechldbrwqhpmrlwjcrjjiwtnebephdxtmzwtbxsmqyqzdkaeyufrvslqbwlme
    ybjcagnapjlvhtsthlqltkagubrwoezrfezieomgkqekirqhalatrdvxwlpsdh
    jpxlmsxemohdhxexrgfgkibwadotwdijxbihyjdbhbttgbcyawxgkondonhzvp
    glpilhnvjlwhvweczvpiqhgfdlrcexlgyval
    ```
    
## What to submit

For the final submission, upload your file(s) on canvas. You must include: 
The program functions that you used for encryption, decryption, and for breaking encryption; functions should have test examples and descriptions. 

A file (ideally a pdf) with the description of all the methods you've tried and all of the successfully decrypted words or parts of words you obtained (or your guesses). 

When submitting group work, one person uploads all the files and submits all the comments, and the other person must post a comment indicating who they have worked with.
