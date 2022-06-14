import { Request, Response } from "express";

import { CreatePaisUseCase } from "./CreatePaisUseCase";

class CreatePaisController {
  constructor(private createPaisUseCase: CreatePaisUseCase) {}

  handle(request: Request, response: Response): Response {
    const { descricao, sigla } = request.body;

    this.createPaisUseCase.execute({ descricao, sigla });

    return response.status(201).send();
  }
}

export { CreatePaisController };
