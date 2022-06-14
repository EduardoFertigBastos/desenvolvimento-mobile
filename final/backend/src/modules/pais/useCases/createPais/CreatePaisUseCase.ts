import { PaisRepository } from "../../repositories/PaisRepository";

interface IRequest {
  descricao: string;
  sigla: string;
}

class CreatePaisUseCase {
  constructor(private paisesRepository: PaisRepository) {}
  execute({ descricao, sigla }: IRequest) {
    this.paisesRepository.create({ descricao, sigla });
  }
}

export { CreatePaisUseCase };
