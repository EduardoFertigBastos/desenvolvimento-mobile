import { PaisRepository } from "../../repositories/PaisRepository";
import { CreatePaisController } from "./CreatePaisController";
import { CreatePaisUseCase } from "./CreatePaisUseCase";

const paisRepository = PaisRepository.getInstance();
const createPaisUseCase = new CreatePaisUseCase(paisRepository);
const createPaisController = new CreatePaisController(
  createPaisUseCase
);

export { createPaisController };
