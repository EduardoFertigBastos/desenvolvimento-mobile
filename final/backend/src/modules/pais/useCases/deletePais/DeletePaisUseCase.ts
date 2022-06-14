import { PaisRepository } from "../../repositories/PaisRepository";

class DeletePaisUseCase {
  constructor(private paisesRepository: PaisRepository) {}
  execute(id: string) {
    this.paisesRepository.delete(id);
  }
}

export { DeletePaisUseCase };
