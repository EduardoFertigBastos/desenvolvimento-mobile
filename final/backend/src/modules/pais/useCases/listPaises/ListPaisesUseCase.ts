import { Pais } from "../../model/Pais";
import { PaisRepository } from "../../repositories/PaisRepository";

class ListPaisesUseCase {
  constructor(private paisesRepository: PaisRepository) {}
  execute(): Pais[] {
    const paises = this.paisesRepository.list();

    return paises;
  }
}

export { ListPaisesUseCase };
