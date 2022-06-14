import { Request, Response } from "express";

import { UpdatePaisUseCase } from "./UpdatePaisUseCase";

class UpdatePaisController {
  constructor(private updatePaisUseCase: UpdatePaisUseCase) {}

  handle(request: Request, response: Response): Response {
    const { id } = request.params;
    const { descricao, sigla } = request.body;

    this.updatePaisUseCase.execute(id, { descricao, sigla });

    return response.send();
  }
}

export { UpdatePaisController };
