# Group-32-OOD-Project

## Project description
TRASHMAN är ett avfallshanteringsprogram där användaren kan skapa produkter utifrån en materiallista och se miljöpåverkan på dessa. Programmets syfte är att hjälpa företag nå sina klimatmål och bidra till en renare planet.

System Purpose (Varför ska programmet finnas?)
I programmet ska man kunna skapa produkter, lista material, visa produktlista och beräkna miljöpåverkan.

## Teamroller
### Karin
- MainMenu
- Main
- Lista produkter
- [NY] SimpleSumStrategy
- [NY] WeightedByLifespanStrategy


### Johanna
- ProductMenu
- Skapa produkt
- [NY] MaterialTests

### Anton
- MaterialMenu
- Lista material
- [NY] Refactor --> ListOfMaterials

### Da Jing
- ReportMenu
- InputValidator
- Visa produktens återvinningsguide
- [NY] RecyclingsGuidanceTest
- [NY] Uppdatera RecyclingsGuidance med nya material.

## Git workflow description
Varje person kommer jobba i sin egen branch. Vi kommer ha en development branch som vi pushar till innan vi mergear till main (protected main och pull requests). 

### Mall till namngivning av branches:
- *type/category/method*

### Exempel:
- *feature/products/addProducts*
- *bugfix/products/removeProducts*
- *development/readMe/updates*

## List of domain concepts

### Nouns (Concept)
- Produkt (Entity)
- Material
- Kategori (Value object)
- Miljöpåverkan
- Livslängd (Value object)
- Återvinningsguide (Service)

### Verbs (Responsibilities)
- “Environmental Impact Calculation”
- Lista produkter och material
- Skapa produkt
- Visa återvinningsguide
- Definiera material

## Architectural Rationale
Presentationslagret kan bara få information från applikationslagret, och applikationslagret kan bara få information från domänlagret. Domänlagret har bara sin egen information. Om presentationslagret kallar på domänlagret så bryter vi reglerna.

Interfacet ImpactCalculationStrategy har vi placerat i domänlagret eftersom den är en egen entity, och det är enbart 2 klasser som implementerar ImpactCalculationStrategy (SimpleSumStrategy + WeightedByLifespanStrategy).

Vi tänkte först att ImpactCalculationStrategy skulle placeras i applikationslagret då abstraktklassen ska implementeras. Sedan fick vi reda på att alla klasser i domänlagret kan kommunicera mellan varandra och därmed flyttade vi klassen till domänlagret.

### se.group32.presentation
- MainMenu
- MenuInterface
- MaterialMenu
- ProductMenu
- ReportMenu
- InputValidator

### se.group32.application
- ProductManager
- MaterialManager

### se.group32.domain
- Product
- Material
- RecyclingGuidance
- ImpactCalculationStrategy
- SimpleSumStrategy
- WeightedByLifespanStrategy

## Design Patterns
### Strategy
Vi har redan sen tidigare en Strategy, genom att ha interfacet ImpactCalculationStrategy som SimpleSumStrategy och WeightedByLifespanStrategy implementerar. Detta gör att det är enkelt att lägga till fler strategier ifall det behövs.

### Factory
Eftersom att i vårt program gör inte användaren ett val om vilken uträkning den vill göra, utan får båda två samtidigt, behöver vi inte en Factory.

## Use Cases
- Skapa produkt
- Lista produkter
- Lista material
- Beräkna produktens impact
- Hämta information om materialet (återvinningsguide, impact, namn)
- Visa produktens återvinningsguide