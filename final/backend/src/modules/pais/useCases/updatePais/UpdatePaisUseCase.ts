import { PaisRepository } from "../../repositories/PaisRepository";

interface IRequest {
  descricao: string;
  sigla: string;
}

class UpdatePaisUseCase {
  constructor(private paisesRepository: PaisRepository) {}

  execute(id: string, { descricao, sigla }: IRequest) {
    this.paisesRepository.update(id, { descricao, sigla });
  }
}

export { UpdatePaisUseCase };
