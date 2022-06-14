import { Request, Response } from "express";

import { DeleteProdutoUseCase } from "./DeleteProdutoUseCase";

class DeleteProdutoController {
  constructor(private deleteProdutoUseCase: DeleteProdutoUseCase) {}

  handle(request: Request, response: Response): Response {
    const { id } = request.params;

    this.deleteProdutoUseCase.execute(id);

    return response.send();
  }
}

export { DeleteProdutoController };
