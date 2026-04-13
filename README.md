# Group-32-OOD-Project

## Project description
TRASHMAN är ett avfallshanteringsprogram där användaren kan skapa produkter utifrån en materiallista och se miljöpåverkan på dessa. Programmets syfte är att hjälpa företag nå sina klimatmål och bidra till en renare planet.

System Purpose (Varför ska programmet finnas?)
I programmet ska man kunna skapa produkter, lista material, visa produktlista och beräkna miljöpåverkan.

## Teamroller – TBA.


## Git workflow description
Varje person kommer jobba i sin egen branch. Vi kommer ha en development branch som vi pushar till innan vi mergear till main (protected main och pull requests). 

### Mall till namngivning av branches:
- *type/category/method*

### Exempel:
- *feature/products/addProducts*
- *bugfix/products/removeProducts*

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

Interfacet ImpactCalculationStrategy har vi placerat i applikationslagret eftersom den tar in parametern Product, och behöver därför information om Product som ligger i domänlagret.

### se.group32.presentation
- Menu

### se.group32.application
- ApplicationManager
- ProductManager

### se.group32.domain
- Product
- Material
- ImpactCalculationStrategy
- SimpleSumStrategy
- WeightedByLifespanStrategy
- RecyclingGuidance


