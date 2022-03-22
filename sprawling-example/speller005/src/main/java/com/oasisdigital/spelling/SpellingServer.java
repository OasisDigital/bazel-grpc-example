package com.oasisdigital.spelling;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import io.grpc.*;
import com.oasisdigital.spelling.api.*;

import java.io.IOException;

public class SpellingServer
    extends SpellCheckerGrpc.SpellCheckerImplBase {
  Set<String> dictionary = new HashSet<String>();
  static int port = 8600 + 5;

  SpellingServer() {
    String words = new String("abandon|abdominal|abigail|abode|above|absences|absorbent|abundant|academic|accept|accessory|accommodate|accomplished|accountability|accumulation|accusers|aches|acknowledge|acquaintance|acrobat|activated|actors|acupuncturist|added|additions|adequate|adjust|administration|admirer|admittedly|adopt|adoring|advancements|adventurous|advertisers|advisor|aerospace|affectionate|affirm|aforethought|afterward|agencies|aggravation|agitated|agreeing|ahold|ailing|ain|airlines|airtight|alameda|alastor|alcoholic|alerts|alibis|alimony|alleging|alligator|alluding|aloft|alpine|altercation|although|ama|amazingly|ambitions|amend|amigos|amongst|amply|amuses|analysis|anatomically|ancients|anesthesiology|angiogram|anguish|ankles|announcement|annoyingly|anomaly|answers|antennae|antibodies|antihistamine|antler|anymore|apartheid|apocalypse|apology|apparition|appears|appetizer|applesauce|appoint|appreciation|approaches|approximately|aquatic|arcade|architects|argentine|argyle|arm|arms|arrange|arrests|arrow|arterial|artifact|artsy|ashes|asking|aspire|assaulted|assertiveness|assigning|assisting|assumed|assures|astral|asylum|atomic|attach|attacks|attendants|attitude|attribute|audiences|auditorium|aunties|author|autistic|automaton|ava|avengers|avoidance|awakened|awed|awry|baba|babysitter|backed|backpack|backstreet|bad|baffled|baggy|bailing|bakery|balcony|baller|ballots|baloney|band|bangers|banker|banner|baptists|barbecues|barely|barging|barlow|baroque|barricade|barstool|basements|basin|bassinet|bathe|baton|battlefield|bawling|beaches|beams|bearer|beater|beauty|becoming|bedrooms|beefs|beery|beg|beginning|behavior|bel|believer|bellies|belongings|benched|beneath|benevolent|berating|bertha|bestowed|betrayer|bey|bibliography|bide|biggie|bikes|billiard|bimbos|bins|biology|birdie|birthright|bite|bizarre|blackjack|bladder|blaming|blasphemy|blazer|bleed|blends|blinded|blinked|blithering|blocked|blood|bloodsucker|blotchy|blown|blueberries|blume|blurted|boarder|boatload|bodies|bogus|boldly|bombed|bonded|bones|bonuses|boogie|booklet|boomer|boot|boozing|bored|bossed|bother|bottomless|bouncy|bourne|bowers|bows|boyfriend|bracelets|brags|brainstorming|branching|brats|bravo|breakable|breakup|breather|breeding|brewer|brick|bridges|brig|brilliant|brisket|broadcasting|broiler|bronzing|broomsticks|brow|browse|brunettes|bubbies|buckled|budget|buffoons|bugs|bulbs|bullet|bulls|bumped|bundle|bunking|burdened|burglaries|burn|burritos|busboys|businessmen|bustle|butchers|butterfly|buttons|buzzards|bylaws|cabdriver|cacciatore|caddy|caged|calcium|calendars|calling|calories|cameraman|campfire|canals|cancelled|candlelight|canisters|cannot|canvass|capitalism|cappuccino|captivated|caramel|carcass|cardiology|caregiver|carjacking|carol|carpeting|carrots|carting|carve|cascade|cashmere|cassettes|casually|cataracts|categorically|caters|catsup|causes|caved|cease|celebration|celled|cemetery|centerfold|centuries|certain|certify|chained|chalked|chamomile|chances|channeled|chaperon|chapters|chardonnay|charities|charming|chase|chatted|cheapest|checker|cheddar|cheerleader|cheeses|chemo|chest|chewing|chickening|child|chill|chimps|chipper|chitchat|choices|cholesterol|chop|chore|christening|chubby|chump|chutes|cinematic|circuitry|circumstances|cities|civil|clad|clamoring|clap|clash|classified|claustrophobia|cleaned|cleanses|clears|clerical|clicking|climb|clingy|clippers|clocking|clone|closest|clothes|cloudy|clubbed|clumsily|clutches|coarse|coax|cocaine|cocktails|code|coercion|cognizant|coincidences|cold|colin|collapse|collect|colleen|colon|colony|coloured|combat|combustible|comer|comforting|commander|commencing|comments|commission|committees|commotion|communion|compact|comparatively|compassionate|compete|compilation|complete|compliant|comply|compound|comprise|compute|concealing|concentrate|concerning|concluded|concord|condemning|conditions|condos|confederacy|confessed|confided|confine|confiscating|confront|congenial|congressional|conjuring|conned|conquest|consensus|conserve|consisted|consort|conspiring|constitutional|consulate|consumer|contacts|contaminated|content|continent|continues|contraceptives|contradiction|contributions|controversial|convent|conversion|conviction|cook|coolant|coop|coordinated|copier|copter|cordon|corky|cornflakes|corporate|correcting|correspondent|corruption|cosmically|costumes|cougars|counselling|counterfeit|countries|coupling|court|courtside|coveralls|coward|coworker|crab|crackling|crafty|cranes|crapper|crass|crawlers|crazy|creases|creator|credits|cremated|cretins|cried|criminology|crisis|criticize|crocket|crop|crossing|crowbar|crowns|crude|cruising|crunch|crushes|cryogenic|cube|cuddled|cuisine|cultivated|cumulative|cups|cures|curlers|curry|curtsy|cussing|customs|cuticles|cutters|cyclops|cypress|daddy|dahlia|dalliance|damn|damsels|dandy|daphne|darker|dart|date|daunting|daydream|de|deadlock|deals|deathly|debit|debutantes|decay|deception|decipher|declare|decomposed|decorations|decrypted|deduction|deeper|defeats|defended|defiantly|defining|deflection|defying|dehydrated|delays|deliberation|delightfully|delivers|delusion|demean|democrats|demonstrate|denial|density|depart|depended|deplete|deposit|depressed|depths|derivative|descending|desecrated|deserving|desirable|desperado|despondent|destroyed|detach|detect|detergent|detestable|detours|devastation|deviation|devon|dewars|diagnoses|dialogue|diaries|dick|dictation|died|different|digest|digitally|dilation|dilute|diminutive|dinero|dinks|diphtheria|directed|dirk|disadvantage|disappearances|disapproval|disaster|disciples|discoloration|discount|discovering|discriminate|discussion|disgruntled|dishes|disinformation|dislodge|dismiss|disorder|dispatch|dispensing|displeasure|disputing|disrupted|dissent|dissolving|distinct|distortion|distressing|distrustful|ditching|diver|divide|divorce|do|doctor|dodgeball|dogged|dojo|dollop|domestic|dominick|dong|doodles|doorman|dopey|dorsal|dot|doubly|dour|downgraded|downsize|dozed|drafty|drainage|drape|drawings|dreamer|dredged|dressy|drifter|drinks|drivers|drooling|drops|drug|drums|dryers|duck|dudes|dug|dullness|dumped|dunk|duress|duties|dwellers|dynamics|eagle|earmarked|earring|earwig|easter|eaves|echoes|ecstasy|edged|edition|educational|effecting|effortless|ego|eighteen|ejection|elderly|electorate|electrodes|element|elevator|eliminating|elms|eluded|embankment|embassies|embittered|embroiled|eminence|empathic|empirical|empowered|en|enchant|encounters|encyclopedias|endeavour|endorsements|enemy|engaged|engines|enhancer|enlighten|enough|ensconced|entail|entertain|entice|entomologist|entrepreneurial|environment|epidemic|epsilon|equipment|erasers|erogenous|erred|escalator|escorted|essays|estate|estrogen|ether|eugenia|evacuated|evaporate|event|everybody|evidenced|evolutionary|exaggerate|examining|exceeds|exceptionally|excite|exclusive|excusing|executor|exes|exhibited|exigent|existing|exorcise|expectancy|expel|experienced|expertise|explanations|exploited|explosions|exposes|expressly|extensive|extinct|extra|extradition|extreme|eyebrow|eyesight|fabricated|facetious|factions|faculty|failings|fairer|faithfulness|fallback|faltered|famished|fanfare|fantasizing|farewell|fart|fascist|fastest|fatherhood|fattest|fave|favours|fearless|feats|fedora|feel|feline|fellows|feminine|fend|fertile|festival|fetuses|fiance|fibrosis|fiefdom|fiercest|fifty|figure|filibuster|film|filth|finalize|financing|finer|fingerprints|fire|firefighters|fires|firs|fishes|fit|fiver|fixing|flagging|flaky|flanks|flaring|flask|flattery|flaw|flecks|fleshy|flickering|flinch|flips|flock|floor|flops|flounder|flows|flung|flushed|flying|focusing|foiled|folks|fond|fool|football|footsteps|forbid|forcing|foreign|foresight|forfeit|forgetful|forgo|formality|forms|fort|fortnight|forward|fouled|four|foxhole|fragment|framing|frantic|fraught|freaky|freelance|freeways|frequencies|freshly|friend|frigging|fringe|frog|frost|fruitcake|fry|fuels|fulfilling|fumigating|fundamentally|fungi|furiously|furthermore|fussing|gabbing|gaggle|gala|galling|gambit|gamut|gangsters|garcon|gargoyles|garrison|gasp|gatehouse|gaudy|gay|geared|gees|gem|generals|generosity|genie|gentlemanly|geographically|gerbil|gestation|ghastly|gibberish|gigantic|gills|ginny|girth|giving|gladly|glare|glazer|glimmer|global|glory|glued|gnawing|goat|goblins|godly|going|gondola|good|goody|goonies|gory|gouged|governmental|grace|graded|graduation|grams|granddaughters|grandpa|grant|graphite|grateful|graves|greaseball|greedy|gremlin|grievance|grilled|grinds|grips|groggy|grope|grouch|groundwork|groves|grub|grumpy|guarded|guerrilla|guidance|guilty|gullible|gunned|gurney|gutter|gypsy|hacking|hags|haircut|hairs|hallelujah|hallway|hamburgers|hamsters|handed|handled|handshake|hanger|hank|happenings|harassing|hardened|hare|harms|harridan|hash|hat|hates|hauls|haw|hayward|he|headgear|headlong|heady|healthy|hearsay|heartburn|heat|heaved|heavyweight|hedging|height|heirlooms|heller|helmets|helplessly|hemorrhaging|hens|herding|hernia|herring|hessian|hibernation|hidden|high|highly|hiker|hillside|hinted|hips|hissing|hitchhike|hives|hobbies|hocking|hogwash|holdings|holiest|holly|home|homeopathic|homey|homosexuals|honeymooning|honored|hoodlums|hooky|hooter|hopelessness|hordes|hornets|horrified|horseradish|hospitable|hostess|hotdog|hotter|house|houseman|how|hubby|huffing|huh|humanity|humdinger|humiliations|humour|hunch|hungry|hunters|hurricanes|husband|hustler|hydraulic|hymns|hyphen|hypocritical|hysterical|iced|icons|ideas|ideology|idol|ignite|iguana|illicit|illustrate|imagination|imbecilic|immediate|immobilize|impact|impatience|imperative|impersonator|implicate|implore|importing|impostor|impression|improperly|improvising|inaccessible|inaugural|incarcerated|incessantly|incinerate|incognito|incomprehensible|incorporate|incredibly|indebted|independent|indications|indifference|indiscretion|induce|industrial|inevitable|infant|infection|infestation|infinity|inflexible|influenza|informer|infused|inhabit|inherited|initiate|injector|inland|innocence|input|insanity|insensitive|insightful|insisted|inspecting|inspiring|instantaneous|instincts|instruction|insulin|insurrection|intellectually|intensely|interact|intercourse|interferes|internal|interpret|interrogation|interstellar|interviews|into|intrigues|intros|inundated|invent|investigated|investments|invited|involves|ironically|irreparable|irritated|isotopes|item|jabbering|jacket|jaguar|jamboree|japan|javelin|jealousy|jelly|jerkin|jest|jewelers|jiggle|jin|jobs|jogger|joint|jolt|journalistic|joys|judgmental|jugs|jumble|jumpy|junkies|justice|kahuna|karat|keeled|kelly|kerry|keys|kickboxing|kidding|kids|kiln|kinder|kingdoms|kismet|kite|knapsack|knickers|knob|knockout|knowledgeable|kooky|label|labrador|lacey|lactose|lady|laker|lambs|land|landlords|lang|lapel|larch|laryngitis|lashing|late|latrine|laughter|laura|lawman|lawyers|layout|leads|leaks|lear|leash|lectures|leering|legal|legion|legwork|lending|leopards|lessee|letterhead|levels|lex|libel|libraries|licked|lied|lifeguard|lifetimes|lighten|lightness|liking|lime|limitless|line|lineup|linked|lippy|lira|listing|literate|littlest|livid|loaf|loathing|loca|locations|locks|lodging|logically|lone|longest|looker|loony|loosened|loran|loses|lottery|lounging|loveless|lovesick|lowery|lozenges|lucked|lukewarm|lump|luncheon|lurch|lust|lying|mac|machine|maddening|madre|maggot|magnetism|maharajah|mailer|mainline|majored|makeshift|malfunctioning|malls|managed|mandate|mangoes|maniacal|manifesto|manipulative|manning|mantle|manuscript|marble|margaritas|marina|marker|marlin|marrow|marten|marvellous|mashed|massa|masseur|masterpieces|matched|materialized|mathematics|matted|matzoh|maxim|mayflower|mead|meanie|measles|meathead|med|medic|medicines|medium|melding|meltdown|mementos|memory|menial|mention|mercer|merger|mermaid|mesmerizing|messing|metaphorical|methadone|mettle|microfilm|middleweight|midtown|mignon|mile|milking|millimeter|mime|mindful|minerals|minimums|minks|minus|mirror|mischief|misery|misinterpret|misogynistic|missiles|missus|mistress|mite|mixers|moat|mockery|modem|modified|mojo|mole|moll|momentarily|monarchs|monger|monkey|monoxide|monthly|moody|moot|mor|moreover|morons|mortals|mosquito|mothballs|motivate|motorbike|mounds|mourned|mouthful|movers|moxie|muddle|muggers|mulled|multiplex|mummies|mural|murky|museums|musing|mustang|mutilated|myriad|mystified|nachos|naive|nametag|nap|narcissism|narrowing|nationally|natured|navigate|ne|necessary|nectar|needlessly|neglected|negotiating|neighbour|nepotism|nest|neuroses|neve|newfound|newsroom|nicely|nicknamed|nightclub|nights|nineteen|nipping|nitwit|nod|noir|nominated|nonissue|noose|northeast|nosedive|not|notepad|notification|noun|novelty|nub|nuisance|numbness|nurses|nutritional|nympho|oatmeal|objected|obligation|obnoxious|observation|obsessing|obstructed|occasions|occupying|octopus|odorless|offenders|office|offset|ohm|okeydokey|olive|omitted|ongoing|oops|openings|operation|opponent|opposite|optimist|oracles|orbital|ordered|ordnance|organization|orgies|originally|orphan|ostensibly|ouch|outbid|outdone|outgrew|outlaws|outnumbered|outrun|outvoted|over|overcame|overdone|overflowing|overkill|overpaid|overreaction|oversized|overthink|overwhelmingly|owl|oxen|pac|pacing|pact|padre|paging|painless|pair|paleontologist|palpable|pamphlet|pandora|panned|pants|papers|parachutes|parakeet|parameters|parasitic|parental|parka|parlour|partial|particular|partners|passable|passing|past|pasts|patent|pathological|patients|patrolman|pattern|pavilion|payable|payoffs|peach|pearls|pecker|peddle|pedicures|peeks|peering|pellets|penalty|penetration|penned|penthouse|perceive|perchance|perform|perfumes|periphery|perky|peroxide|persecuting|personalities|perspectives|peruse|pest|peter|pets|pharaohs|pheasants|philharmonic|phoenix|photo|photography|physicists|piazza|pickled|picture|piecing|pigeons|pike|pillage|pimping|pinched|pinhead|pinot|pipe|pis|piston|pitfalls|pivot|placebos|plaid|planes|planners|plasma|platform|plausible|playground|playtime|pleasant|pleasuring|plop|plucked|plumbing|plus|pocket|poem|pointed|poisoned|polar|policy|politicians|polls|polymerization|ponies|pooh|poorhouse|poppies|porcelain|pornographers|porter|portrays|positioning|possessing|postage|postmark|posture|pothole|potty|pouring|powered|practice|prairie|prank|preach|preceded|precision|predict|preface|pregnancy|premature|premonition|preposterous|prescribes|presently|presided|pressman|presumed|pretext|prevent|prey|pricked|primal|primo|principle|prioritize|privacy|pro|problem|proceeds|procrastinate|prodigal|productive|professionally|profound|programs|prohibits|prolong|promo|promptly|proofing|properties|proportioned|propped|prosecute|prospects|protecting|protestants|prototype|proven|providing|provoked|prudent|psst|psycho|psychopathic|puberty|publicly|puddle|pull|pulses|punches|punished|punt|puppy|purest|purple|pursuing|pushing|puzzle|pyromaniac|quaking|quantities|quarter|queller|quibble|quieter|quintuplets|quiver|quotes|race|racked|radial|radioed|rag|raid|railroads|rainy|rake|ramifications|rancho|ranges|rants|rapists|rascals|rather|rations|ratty|ravish|reach|reactionary|reading|realist|really|reappeared|reasonably|reassure|reboot|recalled|receipts|receptive|recital|reckoning|recognizance|recommended|reconnected|recording|recreate|recruiting|recuse|redefine|redo|redundancies|reeking|reeve|referral|refining|reform|refrigerators|refuses|regardless|regimen|registering|regroup|rehab|rehearsing|reinforced|reiterate|rejuvenated|relation|relaxation|relentless|relies|relive|remain|remarks|remembering|remission|removed|rendezvous|renovate|renting|repair|repeat|repetitious|replaying|reportedly|representative|reprimanded|reptile|reputed|requires|reschedule|researcher|resentful|reserving|resides|resist|resonance|respected|respond|responsive|restless|restricted|results|retainer|rethink|retort|retrieve|reunion|reveals|reverence|reviewed|revive|revolutionize|rewarding|rhinestone|rib|rick|riddle|ridiculed|rig|rights|rin|rioja|ripples|risks|ritzy|riviera|roadway|robbed|robin|rockers|rodeo|roll|romancing|roofs|roommate|roots|roses|rotation|roughage|rounding|routine|rowing|rubbers|rudder|ruffled|ruled|rummaging|run|running|rush|ruthless|sabin|sacred|saddest|safeguard|sagging|sails|salad|salesperson|salon|saluted|samples|sand|sandman|sangria|sapiens|sardine|satellites|saturation|savage|savings|sawed|sayonara|scales|scammed|scanners|scared|scarves|scene|schedules|schizophrenia|schnoz|schools|scissor|scooping|scorching|scotch|scouted|scrap|scratch|screams|screwed|scripted|scrub|scud|scummy|seal|seaplane|seashell|seaweed|secret|sectors|sedation|seed|seemed|segment|seldom|selfishly|semantics|semple|senile|sensed|sensors|sentiment|separating|sequined|series|servants|serving|sets|seven|severe|sewn|sexually|shad|shafted|shakes|shaman|shanghaied|shared|sharpening|shave|she|sheepskin|shelling|shepherds|shifted|shin|shipment|shirt|shocked|shoemaker|shootout|shops|shorten|shorty|shouting|show|showing|shredder|shrinking|shrugged|shuffling|shutting|sicced|sicko|sideline|sidle|sighted|signals|signing|silicone|silver|simp|sims|sincere|singers|sinking|sipped|sis|sites|sixpence|sizes|skaters|skepticism|skidded|skillful|skinny|skis|skylight|slammer|slapping|slaughtered|slayer|sledgehammer|sleepwalk|slept|slide|slimmer|slip|slithering|sloshed|slowly|slumlord|smacked|smarts|smell|smiley|smog|smooch|smothered|smugness|snakebite|snapshots|snazzy|sneezed|sniffling|snivelling|snores|snow|snowing|snuff|soap|sober|socialite|socked|sofa|softness|solarium|solicitation|solution|someday|somewhere|sonnets|soothes|sorcerers|sorrows|soul|soundstage|south|soviet|spacecraft|span|spareribs|sparky|spatial|speaking|specializes|specifics|spectacularly|speculation|speedo|spells|sperm|spiders|spill|spinner|spirits|splash|splicing|spoiler|sponges|spooked|sport|spots|sprang|spreadsheets|sprinkler|spruce|spurt|squander|squat|squeaky|squiggly|squishing|stables|stage|stained|stakeout|stalking|stampede|standish|stapler|starlet|starter|starved|statement|stationary|statue|staying|stealing|steamy|stella|stepmother|sterilize|stewardesses|sticky|stilettos|sting|stint|stitched|stockings|stolen|stoner|stoop|stored|stormy|straight|strains|strangers|strapped|straw|streams|strenuously|stretches|strikes|striping|stroke|stronghold|strummer|stubborn|studios|stuffy|stung|stupid|sty|subatomic|subjecting|submarines|subscription|substances|subtext|suburbs|successes|such|suddenly|suffice|sugars|suicide|suitor|summarily|summoned|sunburn|sunken|sunshine|superfluous|supernatural|supervising|supplier|supposed|surely|surge|surpass|surrendered|survival|suspected|suspicious|swaddling|swan|swat|sweat|sweaty|sweeter|swelling|swim|swing|swiss|swollen|sworn|symbolic|sympathy|synchronicity|synthesize|systems|tablespoon|tackle|tactic|tagged|tailspin|taker|talents|talky|tammy|tangible|tanks|taped|tardiness|tarp|tassels|tattered|taunts|taxing|teacup|teapot|teaspoon|technological|teen|teeth|telepathy|telex|temperamental|temps|tenant|tendonitis|tense|tepid|terminology|terribly|terror|testament|testimony|text|thankful|thaw|thee|then|therapist|thermal|theta|thin|thinners|thirtieth|thorns|thoughtless|threat|thrice|throat|thrower|thug|thunderbolt|tiara|tickle|tidy|tight|tiki|timbre|timid|tiniest|tipper|tired|titanic|toasted|toddler|toga|tolerable|tomato|tomorrows|tongues|took|toothbrushes|topical|tor|torn|tortillas|toss|totem|touchstone|touring|towed|townsfolk|toying|trackers|trader|tragedies|trained|traitors|tranquility|transfer|transgenic|translating|transparent|transvestite|trashed|travel|traverse|treason|treaties|tremble|trendy|triangle|tricked|tried|triggers|trinket|tripping|trollop|tropical|troublesome|truce|truly|trusted|truths|tube|tuition|tuna|turban|turkeys|turnips|tushie|tux|tweed|twerp|twirl|twitchy|types|tyrants|ulcer|umbilical|unaffected|unattended|unbecoming|uncalled|uncle|unconscionable|uncooperative|underage|undergarments|underlings|underprivileged|undertake|undetectable|undone|uneasy|unexpected|unfathomable|unforgiving|ungrateful|unholy|unimaginative|uninterrupted|units|unknowns|unlisted|unmanned|unnerved|unpleasant|unprotected|unreal|unsafe|unseal|unsigned|unsuccessful|unthinkable|untrained|unwashed|unwrapping|updates|uphold|uppers|upset|upstate|urge|urinating|useful|usual|utter|vaccination|vaguest|validity|valves|vanilla|vapid|varies|vastly|vegan|veil|vendor|venomous|ventriloquism|verbal|verily|versed|vessel|veterans|vials|viceroy|victorious|viewer|vigor|villains|vintage|violent|virgin|virulent|visibility|visits|vitally|vocabulary|voices|volleyball|volunteering|votes|voyage|wacko|wage|wailing|waitresses|walk|wallets|waltzing|want|warehouse|warm|warning|warrior|washcloth|wasps|watchers|watering|waved|waxing|weakening|weaning|weather|webster|weds|weenies|weighs|weirdly|weld|welt|western|whacked|whatchamacallit|wheeler|whereas|whichever|whine|whirling|whispering|whites|whole|whooping|wick|widows|wiggled|wilderness|willing|wimp|winding|windward|wining|wins|wired|wised|witch|withdrawn|within|witty|wolf|won|wont|woodsy|wop|workday|workplace|wormed|worrying|worst|woven|wrapper|wreck|wrestling|wrinkles|writing|wrung|yachts|yank|yaw|yearned|yeller|yeti|yodel|yon|yours|yuletide|zapped|zeroed|zing|zombie|");
    for (String word: words.split("\\|")) {
      dictionary.add(word);
    }
  }

  public static void main(String[] args) {
    Server server = ServerBuilder.forPort(port)
        .addService(new SpellingServer()).build();
    try {
      server.start();
      System.out.println("Spelling server listening on port " + port);
      server.awaitTermination();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void check(Candidate request,
      io.grpc.stub.StreamObserver<Result> responseObserver) {
    String word = request.getWord();
    boolean found = dictionary.contains(word);
    System.out.println("Server on port " + port + ", " + word + ":"+ found);
    responseObserver.onNext(Result.newBuilder().setOk(found).build());
    responseObserver.onCompleted();
  }
};
