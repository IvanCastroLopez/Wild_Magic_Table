package com.example.wildmagictable;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class WildMagicDb {

    private static final String TABLE_NAME = "EffectsTable";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SPANISH_EFFECT = "spanishEffect";
    private static final String COLUMN_ENGLISH_EFFECT = "englishEffect";

    private Context context;

    private SQLiteDatabase database;

    public WildMagicDb(Context context) {
        this.context = context;

        this.database = context.openOrCreateDatabase("WildMagicDb", Context.MODE_PRIVATE, null);
        // Create the table if it doesn't exist
        database.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SPANISH_EFFECT + " TEXT, " +
                COLUMN_ENGLISH_EFFECT + " TEXT" + ");");

        // Verificar si la base de datos ya está poblada antes de intentar repoblarla
        if (!isDatabasePopulated()) {
            // La base de datos no está poblada, por lo que podemos hacerlo
            populateTable();
        }
    }

    private boolean isDatabasePopulated() {
        Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        return count > 0;
    }

    private void populateTable() {
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (1, 'Roll on this table at the start of each of your turns for the next minute, ignoring this result on subsequent rolls.', 'Tira en esta tabla al inicio de cada uno de tus turnos durante el próximo minuto, ignorando este resultado en tiradas posteriores.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (2, 'You expend all sorcery points, taking 1d6 force damage for each point lost. You gain temporary hit points equal to the damage taken for the next hour.', 'Gastas todos los puntos de sortilegio, recibiendo 1d6 de daño de fuerza por cada punto perdido. Obtienes puntos temporales de golpe igual al daño recibido durante la próxima hora.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (3, 'Roll on this table twice, ignoring this result on subsequent rolls.', 'Tira en esta tabla dos veces, ignorando este resultado en tiradas posteriores.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (4, 'You cast see invisibility on yourself.', 'Lanzas ver invisibilidad en ti mismo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (5, 'A halo of letters appears around your head. For the next hour, you are aware if someone you can hear is lying.', 'Un halo de letras aparece alrededor de tu cabeza. Durante la próxima hora, eres consciente si alguien a quien puedes escuchar está mintiendo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (6, 'For the next minute, any flammable object you touch that isn’t being worn or carried by another creature bursts into flame. Giggling laughter can be heard from the fire.', 'Durante el próximo minuto, cualquier objeto inflamable que toques y que no esté siendo llevado o llevado por otra criatura estalla en llamas. Se puede escuchar risa risueña desde el fuego.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (7, 'You cast dragon’s breath. The damage type is random.', 'Lanzas aliento de dragón. El tipo de daño es aleatorio.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (8, 'You cast fireball as a 3rd-level spell centered on yourself.', 'Lanzas bola de fuego como un hechizo de nivel 3 centrado en ti mismo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (9, 'You cast ice storm as a 4th-level spell centered on yourself.', 'Lanzas tormenta de hielo como un hechizo de nivel 4 centrado en ti mismo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (10, 'You cast magic missile as a 5th-level spell.', 'Lanzas misil mágico como un hechizo de nivel 5.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (11, 'You cast reduce on yourself.', 'Te lanzas reducir sobre ti mismo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (12, 'Roll a d10. Your height changes by a number of inches equal to the roll. If the roll is odd, you shrink. If the roll is even, you grow.', 'Tira un d10. Tu altura cambia por una cantidad de pulgadas igual al resultado. Si el resultado es impar, te encoges. Si el resultado es par, creces.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (13, 'Ill omen falls upon you. When making an ability check, attack roll, or saving throw, the DM may force you to roll with disadvantage once.', 'Un mal presagio cae sobre ti. Al realizar una tirada de habilidad, tirada de ataque o tirada de salvación, el DM puede obligarte a tirar con desventaja una vez.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (14, 'You cast confusion centered on yourself.', 'Lanzas confusión centrada en ti mismo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (15, 'You cast hold person on a creature within 20 feet. If you choose no creature, you cast it on yourself.', 'Lanzas paralizar a una criatura dentro de 20 pies. Si no eliges ninguna criatura, te lanzas el hechizo a ti mismo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (16, 'For the next minute, you regain 5 hit points at the start of each of your turns.', 'Durante el próximo minuto, recuperas 5 puntos de golpe al inicio de cada uno de tus turnos.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (17, 'For 10 minutes, you speak in a stranger’s unusual voice. The voice is disruptive, but how it sounds is up to you.', 'Durante 10 minutos, hablas con la voz inusual de un extraño. La voz es molesta, pero cómo suena depende de ti.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (18, 'You grow a long beard made of feathers that remains until you sneeze, at which point the feathers explode out from your face.', 'Te crece una larga barba hecha de plumas que permanece hasta que estornudas, momento en el que las plumas explotan desde tu rostro.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (19, 'For the next minute, creatures within 30 feet of you gain 5 temporary hit points at the start of your turn. These hit points do not stack.', 'Durante el próximo minuto, las criaturas dentro de 30 pies de ti ganan 5 puntos de golpe temporales al inicio de su turno. Estos puntos de golpe no se acumulan.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (20, 'You cast grease centered on yourself.', 'Lanzas grasa centrada en ti mismo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (21, 'Your hair turns bright pink.', 'Tu cabello se vuelve de un rosa brillante.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (22, 'The air charges with magic. Creatures have disadvantage on saving throws against the next spell you cast in the next minute that involves a saving throw.', 'El aire se carga de magia. Las criaturas tienen desventaja en las tiradas de salvación contra el próximo hechizo que lanzas en el próximo minuto que involucra una tirada de salvación.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (23, 'You infuse creatures with magic. Creatures within 30 feet of you have advantage against the next effect that involves a saving throw.', 'Infundes a las criaturas con magia. Las criaturas dentro de 30 pies de ti tienen ventaja contra el próximo efecto que involucra una tirada de salvación.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (24, 'Your skin turns a vibrant shade of blue. A remove curse spell can end this effect.', 'Tu piel se vuelve de un tono vibrante de azul. Un hechizo de quitar maldición puede poner fin a este efecto.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (25, 'You encase yourself in a block of earth that fills all 5-foot spaces surrounding you. If a creature is in a space where the earth appears, they are pushed to the nearest unoccupied space. Each 5-foot section of the block has 20 hit points, and an AC of 17.', 'Te encierras en un bloque de tierra que llena todos los espacios de 5 pies que te rodean. Si una criatura está en un espacio donde aparece la tierra, se empuja al espacio desocupado más cercano. Cada sección de 5 pies del bloque tiene 20 puntos de golpe y una CA de 17.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (26, 'An eye appears on your forehead for the next hour. During that time, you have advantage on Perception checks that rely on sight.', 'Un ojo aparece en tu frente durante la próxima hora. Durante ese tiempo, tienes ventaja en las tiradas de percepción que dependen de la vista.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (27, 'Your hands become iron fists for the next minute. You cannot move your fingers, but your unarmed strikes deal 1d6 bludgeoning damage.', 'Tus manos se convierten en puños de hierro durante el próximo minuto. No puedes mover los dedos, pero tus ataques desarmados infligen 1d6 de daño contundente.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (28, 'For the next minute, all your spells with a casting time of 1 action have a casting time of 1 bonus action.', 'Durante el próximo minuto, todos tus hechizos con un tiempo de lanzamiento de 1 acción tienen un tiempo de lanzamiento de 1 acción de bonificación.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (29, 'You become slightly intoxicated and have difficulty concentrating. You have disadvantage on maintaining concentration on spells for the next hour.', 'Te embriagas ligeramente y tienes dificultades para concentrarte. Tienes desventaja en mantener la concentración en hechizos durante la próxima hora.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (30, 'You teleport up to 60 feet to an unoccupied space of your choice that you can see.', 'Te teletransportas hasta 60 pies a un espacio desocupado de tu elección que puedas ver.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (31, 'For the next minute, any spell you cast with that costs one action allows you to immediately fly 15 feet via magic winds that carry you briefly and deposit you on a surface. This movement doesn’t provoke attacks of opportunity.', 'Durante el próximo minuto, cualquier hechizo que lances con un costo de una acción te permite volar inmediatamente 15 pies a través de vientos mágicos que te llevan brevemente y te depositan en una superficie. Este movimiento no provoca ataques de oportunidad.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (32, 'You are transported to the Astral Plane until the end of your next turn, after which time you return to the space you previously occupied or the nearest unoccupied space if that space is occupied.', 'Eres transportado al Plano Astral hasta el final de tu próximo turno, después de lo cual regresas al espacio que ocupaste anteriormente o al espacio desocupado más cercano si ese espacio está ocupado.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (33, 'You cast misty step, arriving at your location in a burst of delicious foods.', 'Lanzas paso neblinoso, llegando a tu ubicación en una explosión de alimentos deliciosos.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (34, 'Maximize the damage of the next damaging spell you cast within the next minute.', 'Maximiza el daño del próximo hechizo dañino que lances durante el próximo minuto.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (35, 'Icy power swirls around you. For the next minute, you may cast ray of frost as a bonus action.', 'Poder helado gira a tu alrededor. Durante el próximo minuto, puedes lanzar rayo de escarcha como acción de bonificación.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (36, 'Roll a d10. Your age changes by a number of years equal to the roll. If the roll is odd, you get younger (minimum 1 year old). If the roll is even, you get older.', 'Tira un d10. Tu edad cambia por una cantidad de años igual al resultado. Si el resultado es impar, te vuelves más joven (mínimo 1 año). Si el resultado es par, envejeces.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (37, 'Your next damaging spell cast within the next minute creates a spectral fist that knocks the target(s) prone.', 'Tu próximo hechizo dañino lanzado durante el próximo minuto crea un puño espectral que derriba al objetivo o a los objetivos.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (38, '1d6 flumphs controlled by the DM appear in unoccupied spaces within 60 feet of you and are frightened of you. They vanish after 1 minute.', '1d6 flumphs controlados por el DM aparecen en espacios desocupados dentro de 60 pies de ti y te tienen miedo. Desaparecen después de 1 minuto.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (39, 'For the next hour, you leave a trail of flowers, fungi, and moss wherever you step.', 'Durante la próxima hora, dejas un rastro de flores, hongos y musgo dondequiera que pises.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (40, 'You regain 2d10 hit points.', 'Recuperas 2d10 puntos de golpe.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (41, 'You switch positions with a creature of your choice within 60 feet in a puff of smoke.', 'Cambias de posición con una criatura de tu elección dentro de 60 pies en una nube de humo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (42, 'You turn into a potted plant until the start of your next turn. While a plant, you are incapacitated and have vulnerability to all damage. If you drop to 0 hit points, your pot breaks, and your form reverts.', 'Te conviertes en una planta en maceta hasta el inicio de tu próximo turno. Mientras eres una planta, estás incapacitado y tienes vulnerabilidad a todo el daño. Si llegas a 0 puntos de golpe, tu maceta se rompe y tu forma vuelve.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (43, 'You cast grasping vine.', 'Lanzas enredadera aprehensora.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (44, 'For the next minute, you can teleport up to 20 feet as a bonus action on each of your turns.', 'Durante el próximo minuto, puedes teletransportarte hasta 20 pies como acción de bonificación en cada uno de tus turnos.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (45, 'For the next minute, you are moved 5 feet in a random direction at the end of each of your turns.', 'Durante el próximo minuto, te mueves 5 pies en una dirección aleatoria al final de cada uno de tus turnos.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (46, 'You cast levitate on yourself.', 'Lanzas levitar en ti mismo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (47, 'For the next hour, you can walk on walls and ceilings.', 'Durante la próxima hora, puedes caminar por paredes y techos.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (48, 'A unicorn controlled by the DM appears in a space within 5 feet of you, then disappears 1 minute later.', 'Aparece un unicornio controlado por el DJ en un espacio a 5 pies de ti, luego desaparece 1 minuto después.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (49, 'A loud voice narrates your thoughts and actions for the next minute. It can be heard clearly from up to 100 feet away.', 'Una voz fuerte narra tus pensamientos y acciones durante el próximo minuto. Se puede escuchar claramente desde hasta 100 pies de distancia.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (50, 'You can’t speak for the next minute. Whenever you try, pink bubbles float out of your mouth.', 'No puedes hablar durante el próximo minuto. Cada vez que lo intentas, burbujas rosadas salen de tu boca.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (51, 'You cry uncontrollably for the next minute. Whenever you try to speak, you hiccup wildly and snot shoots from your nose.', 'Lloras incontrolablemente durante el próximo minuto. Cada vez que intentas hablar, haces hipos salvajemente y te sale moco de la nariz.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (52, 'A spectral shield hovers near you for the next minute, granting you a +2 bonus to AC and immunity to magic missile.', 'Un escudo espectral flota cerca de ti durante el próximo minuto, otorgándote un bono de +2 a la CA e inmunidad a misil mágico.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (53, 'A banana appears on your shoulder for the next minute. While holding the banana in your hand or mouth, you gain a +2 bonus to all saving throws.', 'Aparece un plátano en tu hombro durante el próximo minuto. Mientras sostienes el plátano en tu mano o boca, obtienes un bono de +2 a todas las tiradas de salvación.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (54, 'You are immune to being intoxicated by alcohol for the next 5d6 days. A tattoo that says “sober” appears on your forehead for the same amount of time.', 'Eres inmune a la embriaguez por alcohol durante los próximos 5d6 días. Un tatuaje que dice \"sobrio\" aparece en tu frente durante el mismo período de tiempo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (55, 'Up to four creatures of your choice within 60 feet are knocked prone by a mysterious force.', 'Hasta cuatro criaturas de tu elección dentro de 60 pies son derribadas por una fuerza misteriosa.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (56, 'Your hair falls out but grows back within 24 hours.', 'Tu cabello se cae, pero vuelve a crecer en 24 horas.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (57, 'Your skin rots and decomposes. You gain disadvantage on all persuasion checks, but undead ignore you unless attacked. This can be alleviated via a greater restoration spell.', 'Tu piel se pudre y descompone. Obtienes desventaja en todas las tiradas de persuasión, pero los no muertos te ignoran a menos que te ataquen. Esto puede aliviarse mediante un hechizo de restauración superior.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (58, 'A modron chosen and controlled by the DM appears in an unoccupied space within 5 feet of you, then disappears 1 minute later.', 'Un modron elegido y controlado por el DJ aparece en un espacio desocupado a 5 pies de ti, luego desaparece 1 minuto después.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (59, 'You can speak with small animals for 1 hour. Birds and critters seek you to tell you random secrets they’ve acquired.', 'Puedes hablar con animales pequeños durante 1 hora. Las aves y las criaturas te buscan para contarte secretos aleatorios que han adquirido.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (60, 'You regain your lowest-level expended spell slot.', 'Recuperas tu ranura de hechizo gastada de menor nivel.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (61, 'Your eyes glow like multicolored lanterns for the next 24 hours.', 'Tus ojos brillan como linternas multicolores durante las próximas 24 horas.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (62, 'For the next minute, you must shout when you speak.', 'Durante el próximo minuto, debes gritar cuando hables.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (63, 'You cast entangle centered on yourself.', 'Lanzas enredar centrado en ti mismo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (64, 'You cast fog cloud centered on yourself.', 'Lanzas nube de niebla centrada en ti mismo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (65, 'You create a burst of psychic feedback to yourself and a creature within 60 feet. The creature takes 6d6 psychic damage and you are stunned until the end of your next turn.', 'Creas una explosión de retroalimentación psíquica para ti mismo y una criatura dentro de 60 pies. La criatura recibe 6d6 de daño psíquico y quedas aturdido hasta el final de tu próximo turno.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (66, 'Up to three creatures of your choice within 30 feet of you take 4d10 lightning damage.', 'Hasta tres criaturas de tu elección dentro de 30 pies de ti reciben 4d10 de daño de relámpago.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (67, 'An illusory copy of you appears. At the start of your next turn, it runs to the nearest creature you regard as an enemy within 60 feet and explodes, dealing 3d10 force damage in a 20 foot radius. If there is no enemy, it runs to you.', 'Aparece una copia ilusoria de ti. Al comienzo de tu próximo turno, corre hacia la criatura más cercana que consideras un enemigo dentro de 60 pies y explota, infligiendo 3d10 de daño de fuerza en un radio de 20 pies. Si no hay enemigo, corre hacia ti.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (68, 'You percieve the nearest creature as saying something hurtful about you. You are frightened of that creature until the end of your next turn.', 'Perceives a la criatura más cercana diciendo algo hiriente sobre ti. Tienes miedo de esa criatura hasta el final de tu próximo turno.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (69, 'A random creature within 30 feet is charmed by you until the end of your next turn.', 'Una criatura aleatoria dentro de 30 pies queda encantada por ti hasta el final de tu próximo turno.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (70, 'Each creature within 30 feet of you becomes invisible for the next minute. The invisibility ends on a creature when it attacks or casts a spell.', 'Cada criatura dentro de 30 pies de ti se vuelve invisible durante el próximo minuto. La invisibilidad termina en una criatura cuando ataca o lanza un hechizo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (71, 'You no longer require food, other than at least one cup of tea a day. If you roll this outcome again, then you revert.', 'Ya no necesitas comida, excepto al menos una taza de té al día. Si obtienes este resultado nuevamente, entonces vuelves a la normalidad.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (72, 'You gain resistance to all damage for the next minute.', 'Obtienes resistencia a todo el daño durante el próximo minuto.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (73, 'You cast fear.', 'Lanzas miedo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (74, 'A random creature within 60 feet of you becomes poisoned for 1d4 hours. If they use an action to vomit and take 3d10 poison damage, then the poisoned condition ends.', 'Una criatura aleatoria dentro de 60 pies de ti queda envenenada durante 1d4 horas. Si usa una acción para vomitar y recibe 3d10 de daño por veneno, entonces la condición de envenenamiento termina.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (75, 'You cast stoneskin on yourself. While the spell is active, your walking speed becomes 10 feet.', 'Lanzas piel de piedra en ti mismo. Mientras el hechizo esté activo, tu velocidad de movimiento se reduce a 10 pies.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (76, 'You glow with bright light in a 30-foot radius for the next minute. Any creature that ends its turn within 5 feet of you is blinded until the end of its next turn.', 'Resplandeces con una luz brillante en un radio de 30 pies durante el próximo minuto. Cualquier criatura que termine su turno dentro de 5 pies de ti queda cegada hasta el final de su próximo turno.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (77, 'You cast speak with dead on the next corpse you touch.', 'Lanzas hablar con los muertos en el próximo cadáver que toques.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (78, 'You cast polymorph on yourself. If you fail the saving throw, you turn into a sheep for the spell’s duration.', 'Te transformas con polimorfia en ti mismo. Si fallas la tirada de salvación, te conviertes en una oveja durante la duración del hechizo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (79, 'You cast bestow curse as a 5th-level spell on the next creature you touch.', 'Lanzas maldición como un hechizo de 5º nivel en la próxima criatura que toques.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (80, 'Illusory butterflies and flower petals flutter in the air within 10 feet of you for the next minute.', 'Mariposas ilusorias y pétalos de flores revolotean en el aire dentro de 10 pies de ti durante el próximo minuto.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (81, 'A massive farting sound emanates from you. It is audible from 300 feet away.', 'Un sonido masivo de flatulencia emana de ti. Es audible desde 300 pies de distancia.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (82, 'You can take one additional action immediately.', 'Puedes tomar una acción adicional de inmediato.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (83, 'Your tongue turns into silver. You speak and understand all languages for an hour.', 'Tu lengua se convierte en plata. Hablas y comprendes todos los idiomas durante una hora.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (84, 'Each creature within 30 feet of you takes 1d10 necrotic damage. You regain hit points equal to the sum of the necrotic damage dealt.', 'Cada criatura dentro de 30 pies de ti recibe 1d10 de daño necrótico. Obtienes puntos de golpe iguales a la suma del daño necrótico infligido.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (85, 'A burst of color erupts from you. Each creature within 30 feet of you heals 3d10 hit points, except you.', 'Una explosión de color surge de ti. Cada criatura dentro de 30 pies de ti se cura 3d10 puntos de golpe, excepto tú.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (86, 'You cast mirror image.', 'Lanzas imagen espejo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (87, 'You cast detect thoughts. This lasts for 1 hour and you do not need to concentrate to maintain the effect. Each time you use your action to focus, you take 1d6 psychic damage.', 'Lanzas detectar pensamientos. Esto dura 1 hora y no necesitas concentrarte para mantener el efecto. Cada vez que usas tu acción para concentrarte, recibes 1d6 de daño psíquico.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (88, 'Toxic pustules grow on your body and explode. Creatures within 5 feet take 3d10 acid damage. For the next 1d6 days you have disadvantage on all Charisma checks.', 'Pústulas tóxicas crecen en tu cuerpo y explotan. Las criaturas dentro de 5 pies reciben 3d10 de daño ácido. Durante los próximos 1d6 días, tienes desventaja en todas las tiradas de Carisma.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (89, 'You cast web.', 'Lanzas telaraña.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (90, 'You become invisible for the next minute. During that time, other creatures can’t hear you. The invisibility ends if you attack or cast a spell.', 'Te vuelves invisible durante el próximo minuto. Durante ese tiempo, otras criaturas no pueden oírte. La invisibilidad termina si atacas o lanzas un hechizo.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (91, 'You learn a random 1st level spell.', 'Aprendes un hechizo aleatorio de nivel 1.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (92, 'If you die within the next minute, you immediately come back to life as if by the reincarnate spell.', 'Si mueres dentro del próximo minuto, vuelves inmediatamente a la vida como si fuera por el hechizo de reencarnar.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (93, 'You become athletic. You have advantage on all strength, constitution, and dexterity checks for the next minute.', 'Te vuelves atlético. Tienes ventaja en todas las tiradas de fuerza, constitución y destreza durante el próximo minuto.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (94, 'Your size increases by one size category for the next minute.', 'Tu tamaño aumenta en una categoría de tamaño durante el próximo minuto.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (95, 'Charisma radiates from you for the next minute. You may use your action to strike a pose. A creature of your choice that can see you gains a d8 inspiration die that they may add to an attack roll, ability check, or saving throw. This die lasts until the end of the minute and does not stack if the creature already has one of these die.', 'El carisma irradia desde ti durante el próximo minuto. Puedes usar tu acción para hacer una pose. Una criatura de tu elección que pueda verte obtiene un dado de inspiración d8 que puede agregar a una tirada de ataque, prueba de habilidad o tirada de salvación. Este dado dura hasta el final del minuto y no se acumula si la criatura ya tiene uno de estos dados.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (96, 'You and all creatures within 30 feet of you gain vulnerability to piercing damage for the next minute.', 'Tú y todas las criaturas dentro de 30 pies de ti obtienen vulnerabilidad al daño de perforación durante el próximo minuto.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (97, 'Reroll, and you may spend 1 sorcery point to move one space up or down this table from the rolled result. You may pay this multiple times to move multiple spaces.', 'Vuelve a tirar y puedes gastar 1 punto de sortilegio para moverte un espacio hacia arriba o hacia abajo en esta tabla desde el resultado obtenido. Puedes pagar esto varias veces para moverte varios espacios.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (98, 'You are surrounded by faint, ethereal music for the next minute.', 'Estás rodeado por una música tenue y etérea durante el próximo minuto.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (99, 'A pillar of wild magic explodes from you, and you regain all expended sorcery points.', 'Una columna de magia salvaje explota desde ti, y recuperas todos los puntos de sortilegio gastados.');");
        database.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (100, 'You cast greater restoration on yourself and regain all lost hit points.', 'Lanzas restauración superior en ti mismo y recuperas todos los puntos de golpe perdidos.');");

    }

    public void insertEffect(String spanishEffect, String englishEffect) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_SPANISH_EFFECT, spanishEffect);
        values.put(COLUMN_ENGLISH_EFFECT, englishEffect);

        database.insert(TABLE_NAME, null, values);
    }

    public List<Effect> getEffects() {
        List<Effect> effects = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                effects.add(new Effect(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return effects;
    }

    public void close() {
        database.close();
    }
}