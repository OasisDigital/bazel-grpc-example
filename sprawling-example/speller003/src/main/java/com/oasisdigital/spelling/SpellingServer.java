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
  static int port = 8600 + 3;

  SpellingServer() {
    String words = new String("aback|abbots|abide|abnormally|abound|absconded|absorb|absurdly|abysmal|accent|accessing|acclimated|accomplices|accordingly|accumulate|accused|ache|acids|acoustics|acre|actions|activity|actuarial|adapting|addition|adenoids|adjourn|administered|admire|admittance|adolescent|adored|advanced|adventurer|advertised|advises|aeroplane|affecting|affiliation|afoot|afternoons|ageing|aggravated|aging|agreeable|ahead|aids|aimlessly|airlifted|airspace|ala|alas|alchemy|alerted|aliases|aligning|allegiance|alliance|allowing|almost|alphabetically|alteration|alternator|always|amazes|ambiguous|ambushed|amicable|amniotic|ampicillin|amused|analogy|anarchists|anchovies|anesthesia|anger|angry|anise|announce|annoyed|anointed|answered|antelope|antibiotic|antidepressants|antisocial|anybody|apache|apiece|apologizes|apparent|appeared|appetite|applejack|apply|appreciated|approach|approving|aqua|arboretum|arches|arena|argumentative|arithmetic|armour|arraigned|arrested|arrogance|arsonist|articles|artists|ash|asked|asphyxiation|assassins|assembly|assign|assistants|assortment|assured|astound|astute|atmosphere|att|attackers|attendance|attic|attractive|audible|auditions|aunt|authenticated|authors|automatically|autumn|avenged|avocado|awake|away|awoke|ba|babu|backdoor|backhand|backstabbing|bacteria|badminton|baggies|bailiff|bakeries|balboa|ballast|balloons|balm|banana|bang|bank|banks|baptism|barbecue|bared|barged|barks|baroness|barrels|barrow|baseman|basics|bass|bates|bathtub|batting|bawdy|be|beamed|bearded|beat|beautiful|become|bedrock|beefcake|beer|before|begin|behaved|being|believe|belle|belonged|ben|bendy|benes|bequest|berserk|bested|betrayals|beware|bibles|bidder|bigger|biker|billboard|billy|bingo|biological|bird|birthmark|bistro|bitty|blacked|blacks|blameless|blarney|blathering|bleak|blender|blimp|blindsided|blisters|blockage|blondes|bloodshot|blossoms|blowhard|blue|bluffing|blurry|board|boathouse|bod|boggling|bold|bombarded|bond|boner|bonnie|boogey|bookish|boom|boosters|booze|borders|bosomy|botched|bottom|bouncer|bourbon|bowel|bowls|boy|brace|bragged|brains|branched|brassieres|bravery|breadth|breakthrough|breathe|breech|brew|bribes|bridesmaids|briefly|brill|brioche|broad|brock|bronze|brooms|brought|browns|brunch|brutally|buckeyes|buddy|buffet|buggy|bulb|bulldoze|bullion|bumming|bunch|bunk|burbs|burgess|burley|burping|bus|businesses|bustier|butcher|buttercup|buttoned|buzz|byes|cabaret|caboose|cadavers|caffeine|calamitous|calculus|caller|calms|camels|camper|can|cancellation|candies|canine|cannonball|canton|caper|capper|captains|car|carbuncle|cardiogram|careful|caring|carnivore|carpentry|carries|carter|cartridge|casa|cashier|casserole|casts|catalyst|catching|caterpillar|catholic|cause|cavalry|cayman|celebrates|cellar|cement|center|centred|ceremonies|certification|chagrined|chalk|chambers|chance|changing|chap|chaps|charades|charismatic|charmed|chartreuse|chat|cheapen|checkbook|checkup|cheering|cheesecake|chemist|chess|chew|chicken|chigger|chiles|chimp|chipmunk|chiseling|chocolatey|choking|choosing|chord|christen|chronicle|chum|churn|cinder|circuit|circumference|cite|civic|civvies|clammed|clanging|clarinet|classier|clause|claymores|cleansed|clearing|clergy|clicked|climate|clinging|clipped|clock|clogs|closer|clothe|clouded|clowns|clump|clutch|coalition|coats|cobwebs|cockroaches|coddle|coerce|cog|coincide|cola|coleslaw|collage|colleague|collectors|collision|colonized|colosseum|comatose|combust|comedies|comforted|command|commemorating|commented|commiserate|committed|commonplace|communicator|commuted|comparable|compass|compensated|competitor|complaint|complexities|complimentary|compost|compressions|compulsively|concealed|conceived|concern|conclave|concocting|condemnation|conditioners|condoning|cones|conferring|confidante|confiding|confirms|conformity|confusing|congregation|conjured|connections|conquering|consecutive|conservative|considers|consolidated|conspire|constitutes|construed|consume|contacted|contains|contender|contesting|continue|contra|contradicted|contributing|controlling|convenient|conversations|convict|coo|cooks|cools|coopers|cope|copping|cordial|corks|cornerstone|coroners|correct|corresponded|corrupted|cosmetics|costs|couch|counsel|counter|counting|couple|courses|courts|cover|coveting|cowering|cozy|crackers|craftsmanship|cranberry|crap|crashes|crawl|craziest|crease|creatively|credit|creeps|crest|crick|criminally|cris|critically|croc|crooks|crossfire|croutons|crowned|crud|cruisers|crumpets|crushed|cry|cubbies|cud|cuffing|cult|cumin|cupid|cure|curl|currents|curtain|cusp|customer|cutesy|cuts|cycles|cynics|dad|dah|daisy|damaging|damper|dandelions|dangling|darken|darndest|database|daughter|day|dazzled|deadline|dealing|death|debating|debut|decapitated|decency|decides|decks|decoder|decorating|decreased|deducted|deemed|defeat|defendant|defiance|define|deflated|defused|degree|delayed|deliberate|delighted|deliveries|deluding|demanding|democrat|demonology|demure|denouncing|denying|dependable|depiction|deposed|deprecating|depriving|derelict|descend|descriptive|deserved|designing|desolate|despising|destitute|destructive|detained|detente|deterrent|detonators|devastating|deviants|devise|devours|diagnose|dialed|diaphragm|diced|dictates|diddly|difference|diffusion|digit|dike|dills|diminish|dined|dining|dioxide|dire|directors|disabled|disappear|disappointments|disarray|discharge|disclosure|discord|discovered|discrete|discusses|disgrace|dish|disinfect|dislike|dismember|disobeyed|disparaging|dispenser|displays|dispute|disrespecting|dissection|dissolved|distended|distort|distress|districts|ditched|divas|dives|divisional|dizzy|docks|documents|does|doily|dolled|dome|dominating|donations|donuts|doorknob|dope|dormitory|dossier|doubled|doughnut|downer|downs|dowser|drafting|drags|dramatically|drawers|dream|dreck|dressing|drift|drinkers|driven|drool|dropping|drowsy|drummer|dry|duce|dud|duffel|dulled|dummy|dung|durable|dusty|dwell|dying|eager|earlobes|earpiece|earthquakes|east|eating|echelon|economy|edema|edited|educating|effect|efficiently|eggshell|eh|ejaculate|elbows|elective|electrocute|elegance|elevates|eliminated|elliptical|elsewhere|embalmed|embarrassingly|embezzler|embracing|emerges|emotionally|emphatically|employment|ems|enamored|encounter|encryption|endeavor|endorse|enema|eng|engineering|enhanced|enjoys|enormous|enrolling|ensure|enterprising|enthusiast|entitles|entrenched|envied|ephemeral|epizootics|equilibrium|erased|erode|erratic|escalated|escargot|ess|establishment|estimation|eth|etiquette|euthanasia|evaluations|evenly|everlasting|evicted|evoked|exacting|examined|exceeding|exception|exchanges|excluding|excused|executive|exerting|exhausts|exhume|existential|exonerated|expansion|expedited|expensive|experiments|explains|exploit|exploring|expose|expressions|extension|exterminator|extortion|extradite|extravagant|eyeball|eyeliner|fabric|faces|facing|factual|failed|fainting|faith|fall|falsely|family|fanciful|fantasize|fare|farms|fascination|fastened|father|fatten|fauna|favors|fearful|feathering|federal|feeding|feisty|felling|female|fences|ferrets|fester|fetish|fey|fibers|fidelity|fiends|fifties|figurative|files|fills|filtered|finalists|financial|fine|fingernails|fins|fired|firepower|firmly|fisherman|fistful|fittings|fixer|flag|flaked|flank|flared|flashlights|flattering|flavour|fleabag|fleeting|flicked|flighty|flippers|floating|flooding|flopping|flossing|flowing|fluids|flurry|flyer|focused|foibles|folk|follows|food|foot|footprints|foray|forces|foregone|foresee|forever|forgery|forgives|formal|formidable|forsaken|fortified|forty|fought|fountainhead|fox|fractures|frames|frankly|fraud|freakish|freedoms|frees|french|fresher|fridge|fries|frigid|frizzy|fronting|frugal|frustrating|fueled|fulfill|fumes|fundamental|funerals|fur|further|fusion|fuzz|gagged|gains|galleries|gals|gammy|gangs|garb|gargling|garnet|gaslight|gate|gathers|gawk|gazpacho|geeks|gelato|general|generators|genetics|gentle|geographic|geopolitical|gestapo|getup|giants|gifts|gilded|ginger|girls|givers|gladiator|gland|glaze|gliders|gloat|glorious|glucose|gnats|goalie|goblet|godlike|goggle|golfing|goober|goods|gooney|gorgeous|gotten|governing|grabby|grad|graduates|grammar|granddaddy|grandmother|granny|graphic|grate|gravel|grazing|greatness|greetings|gridlock|grifters|grinder|griping|grocery|groove|grossly|grounds|grovel|grows|gruesome|guarantees|guerilla|guests|guillotine|gulf|gunman|gunshots|gutless|gynecologist|hacker|haggis|hairball|hairnet|halitosis|hallucinations|hamburg|hams|handcuffed|handkerchief|handrail|hang|hangovers|happened|harass|hardball|hardworking|harmonious|harps|harvest|hastily|hateful|hauled|having|hayseed|hazing|header|headlining|headstone|healthier|hearings|heartbreaking|heartwarming|heats|heavy|hedge|heifer|heiress|hell|helm|helping|hemoglobin|henhouse|hercules|heritage|heroine|hesitating|hiatus|hicks|hierarchy|highlighters|hike|hillcrest|hinges|hippopotamus|hisself|hitch|hitting|hoaxes|hock|hogging|holders|holier|hollow|hombre|homemade|hometown|homosexual|honeymoon|honorably|hood|hooks|hoot|hopeless|hora|horned|horrid|horsemen|hosing|hosted|hotbed|hots|hourly|housekeeper|hovercraft|hub|hue|hugging|humane|humbly|humiliating|humoring|humus|hunger|hunted|hurray|hurtling|hussy|hydrate|hygienist|hyperventilate|hypocrite|hysteria|icebox|icky|ideally|identities|idling|igloo|ignores|illegible|illusion|imaginable|imbecile|immature|imminent|immutable|impartial|impending|impersonated|implement|implies|imported|impossibly|impressed|impromptu|improvise|in|inappropriate|incapacitated|incentives|incidentally|includes|incompetent|inconveniencing|increasingly|incur|indentured|indicating|indie|indirectly|indoor|indulgent|inept|infamous|infected|inferno|infinite|inflating|influencing|informational|infuriates|ingredient|inherit|initially|injection|inkling|innings|innuendoes|insane|insecurity|insidious|insipid|inspect|inspired|instances|instinct|instructed|insulated|insuring|intellect|intends|intently|interchangeable|interfered|intermittent|internship|interrogated|intersection|interviewer|intimidated|intrigue|introductions|intuition|invasion|invested|investing|invitations|involved|ironed|irregularities|irritable|isolated|itching|jab|jacked|jagger|jalopy|janitorial|jaunt|jazzed|jell|jerk|jess|jewel|jiffy|jimmies|job|joey|joining|jollies|journalism|joyful|judging|juggling|jukebox|jumps|junk|jus|ka|kaput|kayaking|kegs|kern|keyhole|kickback|kiddie|kidney|killjoy|kin|king|kip|kit|klutzy|knelt|knitting|knocking|knowingly|koi|la|laborers|lacerations|lacrosse|ladle|laird|lambda|lance|landlady|lane|lap|lar|larvae|lashed|latch|latino|laughingstock|laundering|lawful|lawyer|laying|leadership|leaked|leaps|lease|lecture|leech|leg|legged|legitimate|lemur|lentils|lesions|lets|level|lewd|liars|libido|lichen|lids|life|lifestyle|light|lighting|likes|limbo|limitations|limps|liners|lining|liposuction|liquor|listening|literally|littering|lives|loading|loathed|lobster|locating|locket|lodge|logic|lollipops|long|look|looney|loosely|lopper|loser|lots|louis|lovebirds|lovers|lowering|loyalties|lucifer|luge|lumberjack|lunatics|lungs|luscious|luxury|lyrics|machete|madame|madness|magazines|magnet|magnum|mailboxes|mainframe|majesty|makers|malfeasance|mallard|man|manatees|manger|manhunt|manifested|manipulation|mannered|manticore|manufacturing|mar|mare|marigold|mark|marks|married|marshmallows|marvel|masculinity|masquerading|massaging|masterminded|match|materialistic|mathematician|mats|maturity|max|maybes|maze|meaner|meantime|meatball|mechanism|media|medications|meditation|mel|melons|membranes|memorized|mended|mentality|mercenaries|mere|merle|mesh|messes|metamorphosis|meters|metro|microbes|middle|midterm|mightier|mildew|milk|milligram|milo|mind|miner|minimize|minivan|mints|miraculously|miscarry|miserable|misheard|mismatched|misses|misspent|mistook|misunderstood|mixed|moaning|mock|modelling|modification|moisturize|molds|molester|mom|moms|moneymaker|monitors|monopolizing|monte|mood|moors|mopping|more|moron|mortal|mosey|motels|motion|motley|moulin|mounting|mouth|movement|mowers|mucus|mugged|mules|multiple|mumbles|mundane|murderous|muses|musician|must|mute|muzzle|mystical|na|nailing|names|nanosecond|naps|narrow|nation|naturally|nautilus|nazi|nebula|necromancer|needles|negativity|negotiate|neighborly|nephew|nervousness|neurologist|neutralized|newcomers|newspaper|nibbling|nickels|night|nightmares|nine|nipped|nitrous|nobody|noggin|nominal|nonetheless|noodles|normally|nosebleeds|nostrils|notebook|notices|notwithstanding|novelist|nuance|nudity|numbers|nursed|nutmeg|nylons|oath|obituary|objects|oblivion|observable|obsess|obstetrician|occasional|occupied|oceans|odious|offended|offerings|offing|ogres|okay|ole|omens|ones|ooh|openers|operates|opinions|opposed|optic|or|orbing|ordeal|ordinate|organism|orgasmic|original|ornate|os|otto|outage|outdid|outfitted|outlaw|outlook|outrank|outspoken|ovation|overblown|overdid|overexcited|overheating|overnight|overreacted|oversensitive|overstress|overwhelmed|owes|owns|ozone|pacifier|packing|paddy|pagers|painkiller|paintings|palaces|palomino|pampering|panda|panicky|panting|paperback|parabolic|paragraph|paramedic|parasite|pare|parishioners|parlor|part|particle|partner|pas|passer|passports|pastrami|patchouli|pathetically|patient|patrolled|patten|paved|pax|payments|peacemaker|pear|peck|pedaling|pediatrics|peeked|peeps|pele|penalize|penetrated|pennant|pentagon|peppers|perceptive|perfectly|perfume|periods|perk|permitted|persecute|personable|persons|pertinent|pessimist|petal|petrol|phantoms|phasing|philandering|phobic|phosphate|photographing|physician|piano|pickings|picnic|pieced|pig|pigsty|piling|pimp|pinball|pines|pinning|pious|pirated|pistol|pitchfork|pity|placate|plagues|plan|planned|plants|platelets|platters|players|plaything|pleads|pleasure|pliers|ploy|plumber|plunging|poachers|podium|point|poised|pokey|policies|politically|polling|polyester|ponds|poofs|poorer|poppers|population|porn|portals|portrayal|position|possessed|possum|posting|posts|potentially|pottery|pour|powders|practicality|pragmatic|prancer|praying|precautionary|precise|predecessors|preeclampsia|prefix|prelude|premium|prepared|prescribe|presented|presets|presses|presumably|pretenses|prevailed|previous|pricey|prim|primer|principal|prior|priss|prized|probe|proceeding|proclaimed|prodded|production|professional|profitable|programmer|prohibited|projects|promises|prompter|proof|proper|proportion|proposition|prosciutto|prospective|protect|protest|protocols|prove|provider|provocative|prude|pseudo|psychic|psychology|psychotics|publicist|pucker|puke|pulsating|punch|pungent|punky|puppets|purely|puritans|pursue|pushers|putting|pyramids|quake|qualms|quarry|queer|questions|quid|quintet|quitters|quote|rabies|racist|racy|radio|raft|ragtime|railroad|rains|raisins|rambling|rancher|ranger|rant|raping|raring|rates|rationalizing|rattlesnakes|raving|razors|reacting|readers|realises|realizes|reapers|reason|reassignment|rebels|rec|receding|reception|recipient|reckon|recognition|recommendation|reconnaissance|recorder|recovers|recruited|recuperating|redeem|redneck|reducing|reefs|reenter|referendum|refinement|reflexes|refrigerated|refuse|regarded|reggae|register|regretted|regulations|rehearse|reincarnated|reinvented|rejoicing|relates|relax|releasing|relics|relinquishing|relying|remarkably|remember|reminds|removal|rendered|renewing|rentals|repaid|repayment|repertoire|replacing|report|representation|reprieve|reprogramming|reputation|requirement|reruns|rescuing|resent|reserved|resident|resilient|resolved|respectability|respirator|responsible|resting|restraints|resulted|retain|retarded|retirement|retribution|returning|revealed|revere|reverts|revisit|revolutionaries|reward|rex|rhythms|riches|ridden|ridge|rifling|rightly|riley|rinse|ripping|risked|rituals|riveted|roads|roasts|robe|rocked|rodent|roles|romance|roof|roomie|rooted|rosebush|rotates|rouge|roundabout|router|rowboat|rubbed|ruby|ruffians|ruins|rumbling|rumpled|runner|rural|rut|saber|sacks|saddened|safari|saga|sailor|sal|salesman|salmon|salutations|sample|sanctuary|sanders|sanest|santos|sarcoidosis|satchel|satisfying|sausage|savin|saw|saying|scale|scalping|scanned|scare|scarred|scenario|schedule|schizo|schnauzer|schoolgirl|scientists|scoop|scorched|scorpions|scourge|scrambler|scrappy|screamer|screwball|scribbling|scrounge|scry|scumbag|seafood|seams|seas|seating|seconds|sections|sedate|seductive|seeks|seesaw|seizure|self|seltzer|seminars|sendoff|sensational|sensitivity|sentencing|separately|sequencing|sergeant|serum|services|setback|settling|several|sewers|sexual|shackled|shady|shaker|shalt|shamrock|shards|sharpened|shattered|shawn|sheeny|shelled|shenanigans|shields|shimmering|shiny|shipyard|shoal|shoelace|shooting|shopper|shortcut|shortsighted|shout|shoves|showers|shred|shrink|shrubs|shuffle|shuts|siblings|sickly|sidekick|sidewinder|sighs|signaled|signify|silences|silly|simmer|simplistic|sin|singed|sink|sip|sirree|sitcoms|six|sizeable|skated|skeptic|ski|skilled|skinned|skirt|skunk|slam|slap|slater|slay|sledding|sleepovers|sleight|slicker|slim|slinking|slither|slopes|slowest|slum|sly|smarter|smearing|smiled|smitten|smoky|smorgasbord|smugglers|snails|snaps|snatches|sneer|sniffing|snitch|snooze|snotty|snowflake|snubbed|soaked|sob|social|sociopathic|sodium|softest|solace|soles|solitude|some|someway|sonics|soot|sopranos|sorrel|souffle|soundproof|sous|sovereign|spa|spades|spare|sparkly|spat|speakerphone|specialize|specifically|spectacles|speculate|speedily|speller|spends|spicy|spiking|spine|spirit|spitting|splendor|spoil|spokesperson|spontaneously|spoons|spotlight|sprain|spreads|sprinkle|sprouting|spurred|squall|squashed|squeaking|squid|squish|stabilizing|staffers|stagnant|stake|stalker|stamp|standby|staple|staring|start|starvation|statehood|stating|stats|stay|steal|steamroll|steering|step|stereotypes|stew|sticks|stiles|stimuli|stinks|stirs|stockholders|stokes|stone|stoolie|storage|storming|straddle|strained|strangeness|strap|strategizing|streaming|strengths|stretched|strife|striped|striving|stronger|struggles|stubbed|studies|stuffing|stumps|stunts|stutter|suave|subject|sublime|subpoenaed|subsidy|subterfuge|suburban|succeeds|succumb|suction|suffering|sugarcoat|suggests|suited|sultry|summit|sunbathing|sunglasses|sunset|superego|supermarkets|supervise|supplements|supports|supremely|surfers|surly|surreal|surveillance|sushi|suspicion|swab|swamped|swarming|swearing|sweatshop|sweet|swell|swill|swindled|swirling|swivel|swords|symbiotic|sympathies|sync|synonymous|systematically|tablecloths|tack|tact|taffy|tailors|takeout|talented|talking|tambourine|tangent|tankers|tapas|tar|tarnished|task|tate|taunted|taxicab|teaches|teamsters|teased|technique|teed|teenybopper|telepathic|televised|temper|temporarily|tenacious|tending|tenors|tenuous|termination|terrestrial|territories|terry|testifying|tetherball|thank|thataway|theatrical|themes|theory|thereof|thesis|thigh|thinly|thirteenth|thoracotomy|thoughtful|threads|threshold|thrives|throughway|thrusts|thunder|thyself|tickets|tides|tiger|tightrope|timber|times|tingling|tip|tiramisu|tit|toad|today|toffee|tokens|tom|tommy|tongs|tony|toothache|topes|tops|tormented|torrid|tory|totals|touches|tour|toward|townies|toy|tracked|trademark|trafficker|trails|trait|trance|transcript|transfusion|translate|transmitter|transports|traps|traumatized|travelling|treadmill|treated|trek|trend|trial|triceps|tricycle|triggered|trimmings|triplicate|troll|trophy|troublemakers|troy|truffle|trussed|truthful|tuba|tucking|tumor|tunnel|turk|turner|turtles|tutti|tweaked|twentieth|twinkle|twitch|type|tyranny|ugly|ultrasound|unacceptable|unattached|unbearably|unburden|uncivilized|unconcerned|unconventional|undeniably|underestimating|underline|underpants|understood|undeserving|undo|unearth|unethical|unfaithful|unforgettable|unfunny|unheard|uniformity|unintentionally|unite|unjustly|unlikely|unloved|unnecessary|unparalleled|unprincipled|unraveling|unruly|unscheduled|unsettling|unstuck|untapped|untoward|unwanted|unworthy|update|upheld|upped|ups|upstanding|urchin|urinary|use|ushers|utmost|vacations|vague|validate|values|vandalized|vanquishing|varicose|vasectomy|veering|vehicles|vendettas|venison|ventricle|veracity|verified|versatile|very|vet|viable|vicariously|victoria|view|vigilant|villages|vineyards|violations|vipers|virtuoso|viscount|visitor|vital|vixen|voice|volcanoes|volunteer|voter|vowels|vying|waffles|waif|waitress|wakes|walled|walnut|wangler|wardrobe|warlocks|warned|warren|was|washy|watched|waterfall|watts|waxed|weaken|wealthy|weasel|weber|wedgies|weeks|weighed|weirder|welcomes|wells|west|wha|wharves|wheelchair|where|whey|whimsical|whipping|whisper|whiteness|whodunit|whoop|why|widowed|wigged|wildcats|willfully|wilt|winded|windshield|wingman|winnings|wiping|wiseass|wishing|withdrawals|withhold|witnessing|woke|womb|wondrous|woods|woops|workable|workmen|worldwide|worrisome|worshipping|wounding|wrap|wreaks|wrestle|wrinkle|writes|wrote|ya|yams|yardstick|yearbook|yell|yesterdays|yippie|yolk|youngsters|yuck|zany|zeppelin|zillions|zlotys|zoom");
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
